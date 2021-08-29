package com.example.backeventplanner.service.customer;

import com.example.backeventplanner.facade.customer.CustomerDTO;
import com.example.backeventplanner.persistence.customer.Customer;
import com.example.backeventplanner.persistence.customer.CustomerRepo;
import com.example.backeventplanner.persistence.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public CustomerDTO create(CustomerDTO dto) {
        Customer customer = customerFromDto(dto);
        Customer saved = new Customer();
        Boolean check = checkedUserName(dto.getUserName());
        if (check) {
            saved = customerRepo.save(customer);
        }
        return dtoFromCustomer(saved,check);
    }

    @Override
    public CustomerDTO getById(Long id) {
        Customer byId = customerRepo.getById(id);
        return dtoFromCustomer(byId,true);
    }

    @Override
    public ArrayList<CustomerDTO> getAll() {
        List<Customer> all = customerRepo.findAll();
        List<CustomerDTO> collect = all.stream()
                .map(each -> dtoFromCustomer(each,true))
                .collect(Collectors.toList());
        return (ArrayList<CustomerDTO>) collect;
    }

    /*This method updates only info about customer
     * its not update username, password & role*/

    @Override
    public CustomerDTO updateById(Long id, CustomerDTO dto) {
        Customer byId = customerRepo.getById(id);
        if (dto.getName() != null) byId.setName(dto.getName());
        if (dto.getSurname() != null) byId.setSurname(dto.getSurname());
        if (dto.getGender() != null) byId.setGender(dto.getGender());
        if (dto.getPhoneNumber() != null) byId.setPhoneNumber(dto.getPhoneNumber());
        if (dto.getEmail() != null) byId.setEmail(dto.getEmail());
        if (dto.getDateOfBirth() != null) byId.setDateOfBirth(dto.getDateOfBirth());
        Customer saved = customerRepo.save(byId);
        return dtoFromCustomer(saved,true);
    }

    @Override
    public void deleteById(Long id) {
        customerRepo.deleteById(id);
//        boolean exists = customerRepo.existsById()
    }

    private Boolean checkedUserName(String userName) {
        Customer byUserName = customerRepo.findByUserName(userName);
        boolean check = false;
        if (byUserName == null) {
            check = true;
        }
        System.out.println(check);
        return check;
    }

    private Customer customerFromDto(CustomerDTO dto) {
        Customer customer = new Customer();
        customer.setId(dto.getId());
        customer.setName(dto.getName());
        customer.setSurname(dto.getSurname());
        customer.setGender(dto.getGender());
        customer.setPhoneNumber(dto.getPhoneNumber());
        customer.setDateOfBirth(dto.getDateOfBirth());
        customer.setEmail(dto.getEmail());
        customer.setUserName(dto.getUserName());
        customer.setPassword(dto.getPassword());
        Person person = new Person();
        person.setId(dto.getPersonId());
        person.setUserName(dto.getUserName());
        person.setPassword(dto.getPassword());
        person.setRole(dto.getRole());
        customer.setPerson(person);
        return customer;
    }

    private CustomerDTO dtoFromCustomer(Customer customer,boolean check) {
        CustomerDTO customerDTO = new CustomerDTO();
        if (check) {
            customerDTO.setId(customer.getId());
            customerDTO.setName(customer.getName());
            customerDTO.setSurname(customer.getSurname());
            customerDTO.setGender(customer.getGender());
            customerDTO.setPhoneNumber(customer.getPhoneNumber());
            customerDTO.setDateOfBirth(customer.getDateOfBirth());
            customerDTO.setEmail(customer.getEmail());
            customerDTO.setUserName(customer.getUserName());
            customerDTO.setPassword(customer.getPassword());
            customerDTO.setRole();
            customerDTO.setPersonId(customer.getPerson().getId());
        }
        return customerDTO;
    }
}
