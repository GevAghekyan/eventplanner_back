package com.example.backeventplanner.converter.customer;

import com.example.backeventplanner.controller.customer.models.CustomerRequestModel;
import com.example.backeventplanner.controller.customer.models.CustomerResponseModel;
import com.example.backeventplanner.controller.user.RegistrationModel;
import com.example.backeventplanner.facade.customer.CustomerDTO;

public interface CustomerConverter {
    CustomerDTO dtoFromRequest(CustomerRequestModel requestModel);

    CustomerResponseModel responseFromDto(CustomerDTO dto);

    CustomerRequestModel requestFromRegistrationModel(RegistrationModel model);
}
