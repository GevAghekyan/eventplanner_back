package com.example.backeventplanner.controller.customer;

import com.example.backeventplanner.controller.customer.models.CustomerRequestModel;
import com.example.backeventplanner.controller.customer.models.CustomerResponseModel;
import com.example.backeventplanner.facade.customer.CustomerFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CustomerController {

    private final CustomerFacade customerFacade;

    @Autowired
    public CustomerController(CustomerFacade customerFacade) {
        this.customerFacade = customerFacade;
    }

    @PostMapping("/customer/create")
    public ResponseEntity<CustomerResponseModel> register(@RequestBody CustomerRequestModel requestModel) {
        CustomerResponseModel responseModel = customerFacade.create(requestModel);
        return ResponseEntity.ok(responseModel);
    }

    @GetMapping("/customer/create/{id}")
    public ResponseEntity<CustomerResponseModel> getById(@PathVariable Long id) {
        CustomerResponseModel byId = customerFacade.getById(id);
        return ResponseEntity.ok(byId);
    }

    @GetMapping("/customer/getAll")
    public ResponseEntity<ArrayList<CustomerResponseModel>> getAll() {
        ArrayList<CustomerResponseModel> all = customerFacade.getAll();
        return ResponseEntity.ok(all);
    }

    @PutMapping("/customer/update/{id}")
    public ResponseEntity<CustomerResponseModel> updateById(@RequestBody CustomerRequestModel requestModel, @PathVariable Long id) {
        CustomerResponseModel responseModel = customerFacade.updateById(id, requestModel);
        return ResponseEntity.ok(responseModel);
    }

    @DeleteMapping("/customer/delete/{id}")
    public void delete(@PathVariable Long id) {
        customerFacade.deleteById(id);
    }
}
