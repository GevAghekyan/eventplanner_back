package com.example.backeventplanner.controller.user;

import com.example.backeventplanner.controller.customer.models.CustomerResponseModel;
import com.example.backeventplanner.controller.employee.models.EmployeeResponseModel;
import com.example.backeventplanner.converter.CustomerConverter;
import com.example.backeventplanner.converter.EmployeeConverter;
import com.example.backeventplanner.facade.customer.CustomerFacade;
import com.example.backeventplanner.facade.employee.EmployeeFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {

    private final CustomerConverter customerConverter;
    private final EmployeeConverter employeeConverter;
    private final CustomerFacade customerFacade;
    private final EmployeeFacade employeeFacade;

    @Autowired
    public UserController(CustomerConverter customerConverter, EmployeeConverter employeeConverter,
                          CustomerFacade customerFacade, EmployeeFacade employeeFacade) {
        this.customerConverter = customerConverter;
        this.employeeConverter = employeeConverter;
        this.customerFacade = customerFacade;
        this.employeeFacade = employeeFacade;
    }

    @PostMapping("/registration")
    public ResponseEntity<Boolean> register(@RequestBody RegistrationModel model) {
        System.out.println(model);
        boolean check;
        if (model.getPassword().equals(model.getConfirmPassword())) {
            check = true;
        } else {
            check = false;
        }
        if (check) {
            if (model.getRole().equals("CUSTOMER")) {
                CustomerResponseModel customerResponseModel = customerFacade.create(customerConverter.requestFromRegistrationModel(model));
                if (customerResponseModel.getId() == null) check = false;
            } else if (model.getRole().equals("EMPLOYEE")) {
                EmployeeResponseModel employeeResponseModel = employeeFacade.create(employeeConverter.requestFromRegistrationModel(model));
                if (employeeResponseModel.getId() == null) check = false;
            } else {
                check = false;
                System.out.println("Something gone wrong belong ROLE!!!");
            }
        }
        System.out.println("checking" + check);
        return ResponseEntity.ok(check);
    }
}
