package com.example.backeventplanner.controller.user;

import com.example.backeventplanner.controller.customer.models.CustomerResponseModel;
import com.example.backeventplanner.converter.CustomerConverter;
import com.example.backeventplanner.converter.EmployeeConverter;
import com.example.backeventplanner.facade.customer.CustomerFacade;
import com.example.backeventplanner.facade.employee.EmployeeFacade;
import com.example.backeventplanner.persistence.person.Person;
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

    @Autowired
    public UserController(CustomerConverter customerConverter, EmployeeConverter employeeConverter,
                          CustomerFacade customerFacade, EmployeeFacade employeeFacade) {
        this.customerConverter = customerConverter;
        this.employeeConverter = employeeConverter;
        this.customerFacade = customerFacade;
        this.employeeFacade = employeeFacade;
    }

//    //    @PostMapping(value = "/uploadProfilePicture", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
//    public String uploadPictureToAWS(MultipartFile file) throws IOException {
//
//        InputStream inputStream = file.getInputStream();
//
//        AWSCredentials credentials = new BasicAWSCredentials(
//                "AKIAV2R7TZQJJ7Z2P6HC",
//                "2AfiaAcxwgVD+EcKbJ4ykjHAYDp591X8GAsO8CB6"
//        );
//
//        AWSStaticCredentialsProvider awsStaticCredentialsProvider = new AWSStaticCredentialsProvider(credentials);
//
//        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
//                .withCredentials(awsStaticCredentialsProvider)
//                .withRegion(Regions.US_EAST_1)
//                .build();
//
//        ObjectMetadata objectMetadata = new ObjectMetadata();
//
//        String filename = UUID.randomUUID().toString() + file.getOriginalFilename();
//
//        PutObjectRequest requestFile = new PutObjectRequest("eventplanners3", filename, inputStream, objectMetadata);
//        requestFile.withCannedAcl(CannedAccessControlList.PublicRead);
//        PutObjectResult putObjectResult = s3Client.putObject(requestFile);
//
//        String pictureURL = s3Client.getUrl("eventplanners3", file.getOriginalFilename()).toExternalForm();
//
//        return pictureURL;
//    }

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
    public ResponseEntity<Boolean> login(){
//        System.out.println(person.getId());
        return ResponseEntity.ok(true);
    }
}
