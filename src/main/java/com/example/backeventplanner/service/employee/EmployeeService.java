package com.example.backeventplanner.service.employee;

import com.example.backeventplanner.controller.employee.models.EmployeeShortResponse;
import com.example.backeventplanner.facade.customer.CustomerDTO;
import com.example.backeventplanner.facade.employee.EmployeeDTO;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeService {

    EmployeeDTO create(EmployeeDTO dto);

    EmployeeDTO getById(Long id);

    EmployeeDTO findByUserName(String userName);

    List<EmployeeShortResponse> findAllBySpecialist(String specialist);

    ArrayList<EmployeeDTO> getAll();

    EmployeeDTO updateById(Long id, EmployeeDTO dto);

    void deleteById(Long id);

}
