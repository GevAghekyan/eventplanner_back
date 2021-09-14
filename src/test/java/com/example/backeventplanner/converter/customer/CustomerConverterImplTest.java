package com.example.backeventplanner.converter.customer;
import java.sql.Date;

import com.example.backeventplanner.controller.customer.models.CustomerRequestModel;
import com.example.backeventplanner.controller.customer.models.CustomerResponseModel;
import com.example.backeventplanner.controller.user.RegistrationModel;
import com.example.backeventplanner.facade.customer.CustomerDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

class CustomerConverterImplTest {
    private CustomerConverterImpl customerConverter;

    @BeforeEach
    private void setUp(){
        customerConverter = new CustomerConverterImpl();
    }

    @Test
    public void testDtoFromRequest(){
        CustomerRequestModel customerRequestModel = new CustomerRequestModel();
        customerRequestModel.setName("Asd");
        customerRequestModel.setSurname("Asdyan");
        customerRequestModel.setGender("Female");
        customerRequestModel.setPhoneNumber("+374 000000");
        customerRequestModel.setDateOfBirth(new Date(1/1/2020));
        customerRequestModel.setEmail("asd@gmail.com");
        customerRequestModel.setUserName("asd");
        customerRequestModel.setPassword("ASD");

        Assertions.assertNotNull(customerRequestModel.getPassword());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String result = encoder.encode(customerRequestModel.getPassword());
        org.assertj.core.api.Assertions.assertThat(encoder.matches(customerRequestModel.getPassword(), result)).isTrue();

        CustomerDTO customerDTO = customerConverter.dtoFromRequest(customerRequestModel);
        Assertions.assertEquals(customerRequestModel.getName(), customerDTO.getName());
        Assertions.assertEquals(customerRequestModel.getSurname(), customerDTO.getSurname());
        Assertions.assertEquals(customerRequestModel.getEmail(), customerDTO.getEmail());
        Assertions.assertEquals(customerRequestModel.getGender(), customerDTO.getGender());
        Assertions.assertEquals(customerRequestModel.getDateOfBirth(), customerDTO.getDateOfBirth());
        Assertions.assertEquals(customerRequestModel.getPhoneNumber(), customerDTO.getPhoneNumber());
        Assertions.assertEquals(customerRequestModel.getUserName(), customerDTO.getUserName());

    }

     @Test
    public void testResponseFromDto(){
         CustomerDTO customerDTO = new CustomerDTO();
         customerDTO.setId(1L);
         customerDTO.setName("asd");
         customerDTO.setSurname("Asdyan");
         customerDTO.setGender("Female");
         customerDTO.setPhoneNumber("+374 00000");
         customerDTO.setDateOfBirth(new Date(1/1/2020));
         customerDTO.setEmail("asd@gmail.com");
         customerDTO.setUserName("asd");
         customerDTO.setPassword("ASD");
         customerDTO.setRole();
         customerDTO.setPersonId(1L);

         CustomerResponseModel customer = customerConverter.responseFromDto(customerDTO);

         Assertions.assertEquals(customerDTO.getName() , customer.getName());
         Assertions.assertEquals(customerDTO.getSurname() , customer.getSurname());
         Assertions.assertEquals(customerDTO.getUserName() , customer.getUserName());
         Assertions.assertEquals(customerDTO.getRole() , customer.getRole());
         Assertions.assertEquals(customerDTO.getDateOfBirth() , customer.getDateOfBirth());
         Assertions.assertEquals(customerDTO.getEmail() , customer.getEmail());
         Assertions.assertEquals(customerDTO.getPhoneNumber() , customer.getPhoneNumber());
         Assertions.assertEquals(customerDTO.getId() , customer.getId());

     }

     @Test
    public void testRequestFromRegistrationModel(){
         RegistrationModel registrationModel = new RegistrationModel();
         registrationModel.setImage1("image1.jpg");
         registrationModel.setLogo("logo.png");
         registrationModel.setFirstName("asd");
         registrationModel.setLastName("Asdyan");
         registrationModel.setEmail("asd@gmail.com");
         registrationModel.setPhone("+374 00000");
         registrationModel.setGender("Female");
         registrationModel.setDate(new Date(1/1/2020));
         registrationModel.setUsername("asd");
         registrationModel.setPassword("ASD");
         registrationModel.setConfirmPassword("ASD");
         registrationModel.setRole("CUSTOMER");
         registrationModel.setOccupation("");
         registrationModel.setCompanyName("");
         registrationModel.setPrice(0);
         registrationModel.setDescription("");

         CustomerRequestModel customer = customerConverter.requestFromRegistrationModel(registrationModel);
         Assertions.assertEquals(registrationModel.getFirstName(), customer.getName());
         Assertions.assertEquals(registrationModel.getLastName(), customer.getSurname());
         Assertions.assertEquals(registrationModel.getUsername(), customer.getUserName());
         Assertions.assertEquals(registrationModel.getEmail(), customer.getEmail());
         Assertions.assertEquals(registrationModel.getDate(), customer.getDateOfBirth());
         Assertions.assertEquals(registrationModel.getPhone(), customer.getPhoneNumber());
         Assertions.assertEquals(registrationModel.getPassword(), customer.getPassword());
         Assertions.assertEquals(registrationModel.getGender(), customer.getGender());

     }
}