package com.example.backeventplanner.converter.employee;

import java.sql.Date;

import com.example.backeventplanner.controller.employee.models.EmployeeRequestModel;
import com.example.backeventplanner.controller.employee.models.EmployeeResponseModel;
import com.example.backeventplanner.controller.user.RegistrationModel;
import com.example.backeventplanner.facade.employee.EmployeeDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

class EmployeeConverterImplTest {
    private EmployeeConverterImpl employeeConverter;

    @BeforeEach
    private void setUp() {
        employeeConverter = new EmployeeConverterImpl();
    }

    @Test
    public void testDtoFromRequest() {
        EmployeeRequestModel employeeRequestModel = new EmployeeRequestModel();
        employeeRequestModel.setName("asd");
        employeeRequestModel.setSurname("Asdyan");
        employeeRequestModel.setGender("Female");
        employeeRequestModel.setPhoneNumber("+374 0000");
        employeeRequestModel.setDateOfBirth(new Date(1 / 1 / 2020));
        employeeRequestModel.setEmail("asd@gmail.com");
        employeeRequestModel.setSpecialist("Florist");
        employeeRequestModel.setPrice(1000);
        employeeRequestModel.setAbout("aaaaaaaaaaaaaaaaa");
        employeeRequestModel.setCompanyName(null);
        employeeRequestModel.setUserName("asd");
        employeeRequestModel.setPassword("ASD");

        Assertions.assertNotNull(employeeRequestModel.getPassword());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String result = encoder.encode(employeeRequestModel.getPassword());
        org.assertj.core.api.Assertions.assertThat(encoder.matches(employeeRequestModel.getPassword(), result)).isTrue();

        EmployeeDTO employeeDTO = employeeConverter.dtoFromRequest(employeeRequestModel);
        Assertions.assertEquals(employeeRequestModel.getName(), employeeDTO.getName());
        Assertions.assertEquals(employeeRequestModel.getSurname(), employeeDTO.getSurname());
        Assertions.assertEquals(employeeRequestModel.getUserName(), employeeDTO.getUserName());
        Assertions.assertEquals(employeeRequestModel.getEmail(), employeeDTO.getEmail());
        Assertions.assertEquals(employeeRequestModel.getPhoneNumber(), employeeDTO.getPhoneNumber());
        Assertions.assertEquals(employeeRequestModel.getGender(), employeeDTO.getGender());
        Assertions.assertEquals(employeeRequestModel.getDateOfBirth(), employeeDTO.getDateOfBirth());
        Assertions.assertEquals(employeeRequestModel.getSpecialist(), employeeDTO.getSpecialist());
        Assertions.assertEquals(employeeRequestModel.getPrice(), employeeDTO.getPrice());
        Assertions.assertEquals(employeeRequestModel.getAbout(), employeeDTO.getAbout());

        if (employeeRequestModel.getCompanyName() != null) {
            Assertions.assertEquals(employeeRequestModel.getCompanyName(), employeeDTO.getCompanyName());
        } else {
            Assertions.assertEquals(employeeRequestModel.getName() + " " + employeeRequestModel.getSurname(), employeeDTO.getCompanyName());
        }
    }

    @Test
    public void testResponseFromDto(){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(1L);
        employeeDTO.setName("asd");
        employeeDTO.setSurname("ASD");
        employeeDTO.setGender("Female");
        employeeDTO.setPhoneNumber("+374 0000");
        employeeDTO.setDateOfBirth(new Date(1/1/2020));
        employeeDTO.setEmail("asd@gmail.com");
        employeeDTO.setSpecialist("Florist");
        employeeDTO.setPrice(1000);
        employeeDTO.setAbout("aaaaaa");
        employeeDTO.setCompanyName("aaaaaa");
        employeeDTO.setUserName("asd");
        employeeDTO.setPassword("ASD");
        employeeDTO.setRole();

        EmployeeResponseModel employee = employeeConverter.responseFromDto(employeeDTO);
        Assertions.assertEquals(employeeDTO.getId(), employee.getId());
        Assertions.assertEquals(employeeDTO.getName(), employee.getName());
        Assertions.assertEquals(employeeDTO.getSurname(), employee.getSurname());
        Assertions.assertEquals(employeeDTO.getUserName(), employee.getUserName());
        Assertions.assertEquals(employeeDTO.getEmail(), employee.getEmail());
        Assertions.assertEquals(employeeDTO.getPhoneNumber(), employee.getPhoneNumber());
        Assertions.assertEquals(employeeDTO.getGender(), employee.getGender());
        Assertions.assertEquals(employeeDTO.getDateOfBirth(), employee.getDateOfBirth());
        Assertions.assertEquals(employeeDTO.getSpecialist(), employee.getSpecialist());
        Assertions.assertEquals(employeeDTO.getPrice(), employee.getPrice());
        Assertions.assertEquals(employeeDTO.getAbout(), employee.getAbout());
        Assertions.assertEquals(employeeDTO.getRole(), employee.getRole());
        Assertions.assertEquals(employeeDTO.getCompanyName(), employee.getCompanyName());
    }

    @Test
    public void testRequestFromRegistrationModel(){
        RegistrationModel registrationModel = new RegistrationModel();
        registrationModel.setImage1("image1.png");
        registrationModel.setLogo("logo.jpg");
        registrationModel.setFirstName("asd");
        registrationModel.setLastName("Asdyan");
        registrationModel.setEmail("asd@gmail.com");
        registrationModel.setPhone("+374 00000");
        registrationModel.setGender("Female");
        registrationModel.setDate(new Date(1/1/2020));
        registrationModel.setUsername("asd");
        registrationModel.setPassword("ASD");
        registrationModel.setConfirmPassword("ASD");
        registrationModel.setRole("EMPLOYEE");
        registrationModel.setOccupation("Florist");
        registrationModel.setCompanyName("aaaaaaaa");
        registrationModel.setPrice(1000);
        registrationModel.setDescription("asdasd");

        EmployeeRequestModel employee = employeeConverter.requestFromRegistrationModel(registrationModel);
        Assertions.assertEquals(registrationModel.getFirstName(), employee.getName());
        Assertions.assertEquals(registrationModel.getLastName(), employee.getSurname());
        Assertions.assertEquals(registrationModel.getUsername(), employee.getUserName());
        Assertions.assertEquals(registrationModel.getPassword(), employee.getPassword());
        Assertions.assertEquals(registrationModel.getEmail(), employee.getEmail());
        Assertions.assertEquals(registrationModel.getGender(), employee.getGender());
        Assertions.assertEquals(registrationModel.getPhone(), employee.getPhoneNumber());
        Assertions.assertEquals(registrationModel.getOccupation(), employee.getSpecialist());
        Assertions.assertEquals(registrationModel.getPrice(), employee.getPrice());
        Assertions.assertEquals(registrationModel.getDescription(), employee.getAbout());
        Assertions.assertEquals(registrationModel.getDate(), employee.getDateOfBirth());
        Assertions.assertEquals(registrationModel.getCompanyName(), employee.getCompanyName());
    }

}