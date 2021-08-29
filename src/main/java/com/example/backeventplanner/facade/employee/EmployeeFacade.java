package com.example.backeventplanner.facade.employee;

import com.example.backeventplanner.annotation.Facade;
import com.example.backeventplanner.controller.employee.models.EmployeeRequestModel;
import com.example.backeventplanner.controller.employee.models.EmployeeResponseModel;
import com.example.backeventplanner.converter.EmployeeConverter;
import com.example.backeventplanner.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Facade
public class EmployeeFacade {

    private final EmployeeConverter employeeConverter;
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeFacade(EmployeeConverter employeeConverter, EmployeeService employeeService) {
        this.employeeConverter = employeeConverter;
        this.employeeService = employeeService;
    }

    public EmployeeResponseModel create(EmployeeRequestModel requestModel) {
        EmployeeDTO dto = employeeConverter.dtoFromRequest(requestModel);
        EmployeeDTO saved = employeeService.create(dto);
        return employeeConverter.responseFromDto(saved);
    }

    public EmployeeResponseModel getById(Long id) {
        EmployeeDTO byId = employeeService.getById(id);
        return employeeConverter.responseFromDto(byId);
    }

    public ArrayList<EmployeeResponseModel> getAll() {
        ArrayList<EmployeeDTO> all = employeeService.getAll();
        List<EmployeeResponseModel> collect = all.stream()
                .map(each -> employeeConverter.responseFromDto(each))
                .collect(Collectors.toList());
        return (ArrayList<EmployeeResponseModel>) collect;
    }

//    /*This method updates only info about employee
//     * its not update username, password & role*/

    public EmployeeResponseModel updateById(Long id, EmployeeRequestModel requestModel) {
        EmployeeDTO saved = employeeService.updateById(id, employeeConverter.dtoFromRequest(requestModel));
        return employeeConverter.responseFromDto(saved);
    }

    public void deleteById(Long id) {
        employeeService.deleteById(id);
    }
}
