package com.example.backeventplanner.converter.employee;

import com.example.backeventplanner.controller.employee.models.EmployeeRequestModel;
import com.example.backeventplanner.controller.employee.models.EmployeeResponseModel;
import com.example.backeventplanner.controller.user.RegistrationModel;
import com.example.backeventplanner.facade.employee.EmployeeDTO;

public interface EmployeeConverter {
    EmployeeDTO dtoFromRequest(EmployeeRequestModel requestModel);

    EmployeeResponseModel responseFromDto(EmployeeDTO dto);

    EmployeeRequestModel requestFromRegistrationModel(RegistrationModel model);
}
