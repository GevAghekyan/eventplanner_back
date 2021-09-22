package com.example.backeventplanner.service.customer;

import com.example.backeventplanner.facade.customer.CustomerDTO;

import java.util.ArrayList;

public interface CustomerService {

    CustomerDTO create(CustomerDTO dto);

    CustomerDTO getById(Long id);

    CustomerDTO findByUserName(String userName);

    ArrayList<CustomerDTO> getAll();

    CustomerDTO updateById(Long id, CustomerDTO dto);

    void deleteById(Long id);
}