package com.example.backeventplanner.facade.customer;

import com.example.backeventplanner.annotation.Facade;
import com.example.backeventplanner.controller.customer.models.CustomerRequestModel;
import com.example.backeventplanner.controller.customer.models.CustomerResponseModel;
import com.example.backeventplanner.converter.CustomerConverter;
import com.example.backeventplanner.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Facade
public class CustomerFacade {

    private final CustomerConverter customerConverter;
    private final CustomerService customerService;


    @Autowired
    public CustomerFacade(CustomerConverter customerConverter, CustomerService customerService) {
        this.customerConverter = customerConverter;
        this.customerService = customerService;
    }

    public CustomerResponseModel create(CustomerRequestModel requestModel) {
        CustomerDTO customerDTO = customerConverter.dtoFromRequest(requestModel);
        CustomerDTO dtoReturned = customerService.create(customerDTO);
        return customerConverter.responseFromDto(dtoReturned);
    }

    public CustomerResponseModel getById(Long id) {
        CustomerDTO byId = customerService.getById(id);
        return customerConverter.responseFromDto(byId);
    }

    public ArrayList<CustomerResponseModel> getAll() {
        ArrayList<CustomerDTO> all = customerService.getAll();
        List<CustomerResponseModel> collect = all.stream()
                .map(each -> customerConverter.responseFromDto(each))
                .collect(Collectors.toList());
        return (ArrayList<CustomerResponseModel>) collect;
    }

    /*This method updates only info about customer
     * its not update username, password & role*/

    public CustomerResponseModel updateById(Long id, CustomerRequestModel requestModel) {
        CustomerDTO customerDTO = customerConverter.dtoFromRequest(requestModel);
        CustomerDTO updateById = customerService.updateById(id, customerDTO);
        return customerConverter.responseFromDto(updateById);
    }

    public void deleteById(Long id) {
        customerService.deleteById(id);
    }
}
