package com.example.backeventplanner.converter;

import com.example.backeventplanner.annotation.Converter;
import com.example.backeventplanner.controller.employee.models.EmployeeRequestModel;
import com.example.backeventplanner.controller.employee.models.EmployeeResponseModel;
import com.example.backeventplanner.controller.user.RegistrationModel;
import com.example.backeventplanner.facade.employee.EmployeeDTO;

@Converter
public class EmployeeConverter {

    public EmployeeDTO dtoFromRequest(EmployeeRequestModel requestModel) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setName(requestModel.getName());
        employeeDTO.setSurname(requestModel.getSurname());
        employeeDTO.setGender(requestModel.getGender());
        employeeDTO.setPhoneNumber(requestModel.getPhoneNumber());
        employeeDTO.setDateOfBirth(requestModel.getDateOfBirth());
        employeeDTO.setEmail(requestModel.getEmail());
        employeeDTO.setSpecialist(requestModel.getSpecialist());
        employeeDTO.setPrice(requestModel.getPrice());
        employeeDTO.setAbout(requestModel.getAbout());
        employeeDTO.setUserName(requestModel.getUserName());
        employeeDTO.setPassword(requestModel.getPassword());
        employeeDTO.setRole();
        return employeeDTO;
    }

    public EmployeeResponseModel responseFromDto(EmployeeDTO dto) {
        EmployeeResponseModel employeeResponseModel = new EmployeeResponseModel();
        employeeResponseModel.setId(dto.getId());
        employeeResponseModel.setName(dto.getName());
        employeeResponseModel.setSurname(dto.getSurname());
        employeeResponseModel.setGender(dto.getGender());
        employeeResponseModel.setPhoneNumber(dto.getPhoneNumber());
        employeeResponseModel.setDateOfBirth(dto.getDateOfBirth());
        employeeResponseModel.setEmail(dto.getEmail());
        employeeResponseModel.setSpecialist(dto.getSpecialist());
        employeeResponseModel.setPrice(dto.getPrice());
        employeeResponseModel.setAbout(dto.getAbout());
        employeeResponseModel.setUserName(dto.getUserName());
        employeeResponseModel.setRole(dto.getRole());
        return employeeResponseModel;
    }

    public EmployeeRequestModel requestFromRegistrationModel(RegistrationModel model){
        EmployeeRequestModel employeeRequestModel = new EmployeeRequestModel();
        employeeRequestModel.setName(model.getFirstName());
        employeeRequestModel.setSurname(model.getLastName());
        employeeRequestModel.setGender(model.getGender());
        employeeRequestModel.setPhoneNumber(model.getPhone());
        employeeRequestModel.setDateOfBirth(model.getDate());
        employeeRequestModel.setEmail(model.getEmail());
        employeeRequestModel.setSpecialist(model.getOccupation());
        employeeRequestModel.setPrice(model.getPrice());
        employeeRequestModel.setAbout(model.getDescription());
        employeeRequestModel.setUserName(model.getUsername());
        employeeRequestModel.setPassword(model.getPassword());
        return employeeRequestModel;
    }
}
