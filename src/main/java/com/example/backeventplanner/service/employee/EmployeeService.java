package com.example.backeventplanner.service.employee;

import com.example.backeventplanner.facade.employee.EmployeeDTO;

import java.util.ArrayList;

public interface EmployeeService {

    EmployeeDTO create(EmployeeDTO dto);

    EmployeeDTO getById(Long id);

    ArrayList<EmployeeDTO> getAll();

    EmployeeDTO updateById(Long id, EmployeeDTO dto);

    void deleteById(Long id);

}
