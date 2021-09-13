package com.example.backeventplanner.controller.employee;

import com.example.backeventplanner.controller.customer.models.CustomerResponseModel;
import com.example.backeventplanner.controller.employee.models.EmployeeRequestModel;
import com.example.backeventplanner.controller.employee.models.EmployeeResponseModel;
import com.example.backeventplanner.controller.employee.models.EmployeeShortResponse;
import com.example.backeventplanner.facade.employee.EmployeeFacade;
import com.example.backeventplanner.persistence.portfolio.PortfolioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeFacade employeeFacade;

    @Autowired
    public EmployeeController(EmployeeFacade employeeFacade) {
        this.employeeFacade = employeeFacade;
    }

//    @PostMapping("/employee/create")
//    public ResponseEntity<EmployeeResponseModel> register(@RequestBody EmployeeRequestModel requestModel) {
//        EmployeeResponseModel responseModel = employeeFacade.create(requestModel);
//        return ResponseEntity.ok(responseModel);
//    }

    @GetMapping("/employee/create/{id}")
    public ResponseEntity<EmployeeResponseModel> getById(@PathVariable Long id) {
        EmployeeResponseModel byId = employeeFacade.getById(id);
        return ResponseEntity.ok(byId);
    }

    @GetMapping("/employee/getAll")
    public ResponseEntity<ArrayList<EmployeeResponseModel>> getAll() {
        ArrayList<EmployeeResponseModel> all = employeeFacade.getAll();
        return ResponseEntity.ok(all);
    }

    @PutMapping("/employee/update/{id}")
    public ResponseEntity<EmployeeResponseModel> updateById(@RequestBody EmployeeRequestModel requestModel, @PathVariable Long id) {
        EmployeeResponseModel responseModel = employeeFacade.updateById(id, requestModel);
        return ResponseEntity.ok(responseModel);
    }

    @DeleteMapping("/employee/delete/{id}")
    public void delete(@PathVariable Long id) {
        employeeFacade.deleteById(id);
    }

    @GetMapping("/account/employee/{type}")
    public ResponseEntity<List<EmployeeShortResponse>> getByType(@PathVariable String type) {
        List<EmployeeShortResponse> employeesByType = employeeFacade.getEmployeesByType(type);
        return ResponseEntity.ok(employeesByType);
    }

}
