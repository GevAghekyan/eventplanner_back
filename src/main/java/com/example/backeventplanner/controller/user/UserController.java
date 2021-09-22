package com.example.backeventplanner.controller.user;

import com.example.backeventplanner.converter.customer.CustomerConverter;
import com.example.backeventplanner.converter.employee.EmployeeConverter;
import com.example.backeventplanner.facade.customer.CustomerFacade;
import com.example.backeventplanner.facade.employee.EmployeeFacade;
import com.example.backeventplanner.facade.user.UserFacade;
import com.example.backeventplanner.security.MyUserDetails;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin
public class UserController {

    private final CustomerConverter customerConverter;
    private final EmployeeConverter employeeConverter;
    private final CustomerFacade customerFacade;
    private final EmployeeFacade employeeFacade;
    private final UserFacade userFacade;

    @Autowired
    public UserController(CustomerConverter customerConverter, EmployeeConverter employeeConverter,
                          CustomerFacade customerFacade, EmployeeFacade employeeFacade, UserFacade userFacade) {
        this.customerConverter = customerConverter;
        this.employeeConverter = employeeConverter;
        this.customerFacade = customerFacade;
        this.employeeFacade = employeeFacade;
        this.userFacade = userFacade;
    }

    @PostMapping("/registration")
    public ResponseEntity<Boolean> registerCustomer(@RequestBody RegistrationModel model) {
        boolean check = customerFacade.create(customerConverter.requestFromRegistrationModel(model));
        System.out.println("checking" + check);
        return ResponseEntity.ok(check);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Boolean> registerEmployee(@RequestPart("logo") MultipartFile logo, @RequestPart("image1") MultipartFile image1,
                                                    @RequestPart("body") String body) throws IOException {
        RegistrationModel registrationModel = new ObjectMapper().readValue(body, RegistrationModel.class);
        Boolean check = employeeFacade.create(
                employeeConverter.requestFromRegistrationModel(registrationModel), logo, image1);
        System.out.println(check);
        return ResponseEntity.ok(check);
    }

    @GetMapping(value = "/login")
    public ResponseEntity<Boolean> login(@AuthenticationPrincipal MyUserDetails user) {
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getAuthorities());
        return ResponseEntity.ok(true);
    }

    @GetMapping(value = "/login/events")
    public ResponseEntity<UserResponseModel> loginEvents(@AuthenticationPrincipal MyUserDetails user) {
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getAuthorities());
        UserResponseModel userResponseModel = userFacade.get(user.getUsername());
        return ResponseEntity.ok(userResponseModel);
    }
}
