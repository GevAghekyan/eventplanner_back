package com.example.backeventplanner.converter;

import com.example.backeventplanner.annotation.Converter;
import com.example.backeventplanner.controller.customer.models.CustomerRequestModel;
import com.example.backeventplanner.controller.customer.models.CustomerResponseModel;
import com.example.backeventplanner.controller.user.RegistrationModel;
import com.example.backeventplanner.facade.customer.CustomerDTO;

@Converter
public class CustomerConverter {

    public CustomerDTO dtoFromRequest(CustomerRequestModel requestModel) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName(requestModel.getName());
        customerDTO.setSurname(requestModel.getSurname());
        customerDTO.setGender(requestModel.getGender());
        customerDTO.setPhoneNumber(requestModel.getPhoneNumber());
        customerDTO.setDateOfBirth(requestModel.getDateOfBirth());
        customerDTO.setEmail(requestModel.getEmail());
        customerDTO.setUserName(requestModel.getUserName());
        customerDTO.setPassword(requestModel.getPassword());
        customerDTO.setRole();
        return customerDTO;
    }

    public CustomerResponseModel responseFromDto(CustomerDTO dto) {
        CustomerResponseModel customerResponseModel = new CustomerResponseModel();
        customerResponseModel.setId(dto.getId());
        customerResponseModel.setName(dto.getName());
        customerResponseModel.setSurname(dto.getSurname());
        customerResponseModel.setGender(dto.getGender());
        customerResponseModel.setPhoneNumber(dto.getPhoneNumber());
        customerResponseModel.setDateOfBirth(dto.getDateOfBirth());
        customerResponseModel.setEmail(dto.getEmail());
        customerResponseModel.setUserName(dto.getUserName());
        customerResponseModel.setRole(dto.getRole());
        return customerResponseModel;
    }

    public CustomerRequestModel requestFromRegistrationModel(RegistrationModel model){
        CustomerRequestModel customerRequestModel = new CustomerRequestModel();
        customerRequestModel.setName(model.getFirstName());
        customerRequestModel.setSurname(model.getLastName());
        customerRequestModel.setGender(model.getGender());
        customerRequestModel.setPhoneNumber(model.getPhone());
        customerRequestModel.setDateOfBirth(model.getDate());
        customerRequestModel.setEmail(model.getEmail());
        customerRequestModel.setUserName(model.getUsername());
        customerRequestModel.setPassword(model.getPassword());
        return customerRequestModel;
    }
}
