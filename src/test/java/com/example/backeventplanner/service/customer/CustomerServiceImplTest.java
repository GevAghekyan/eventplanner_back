package com.example.backeventplanner.service.customer;
import com.example.backeventplanner.persistence.person.Person;
import java.sql.Date;

import com.example.backeventplanner.facade.customer.CustomerDTO;
import com.example.backeventplanner.persistence.customer.Customer;
import com.example.backeventplanner.persistence.customer.CustomerRepo;
import com.example.backeventplanner.persistence.person.PersonRepo;
import com.example.backeventplanner.service.person.PersonService;
import com.example.backeventplanner.service.person.PersonServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {
    private CustomerServiceImpl customerService;
    private PersonService personService;
    @Mock
    private CustomerRepo customerRepo;
    @Mock
    private PersonRepo personRepo;

    @BeforeEach
    private void setUp(){
        personService = new PersonServiceImpl(personRepo);
        customerService = new CustomerServiceImpl(customerRepo, personService);
    }

    @Test
    @DisplayName("Test for creating customer with unique username")
    public void testCreateWithUniqueUsername(){
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(1L);
        customerDTO.setName("asd");
        customerDTO.setSurname("Asdyan");
        customerDTO.setGender("Female");
        customerDTO.setPhoneNumber("+374 0000");
        customerDTO.setDateOfBirth(new Date(1/1/2020));
        customerDTO.setEmail("asd@gmail.com");
        customerDTO.setUserName("asd");
        customerDTO.setPassword("ASD");
        customerDTO.setRole();

        Person person = new Person();
        person.setId(customerDTO.getId());
        person.setUserName(customerDTO.getUserName());
        person.setPassword(customerDTO.getPassword());
        person.setRole(customerDTO.getRole());

        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("asd");
        customer.setSurname("Asdyan");
        customer.setGender("Female");
        customer.setPhoneNumber("+374 0000");
        customer.setDateOfBirth(new Date(1/1/2020));
        customer.setEmail("asd@gmail.com");
        customer.setUserName("asd");
        customer.setPassword("ASD");
        customer.setPerson(person);

        Assertions.assertEquals(customer, customerService.customerFromDto(customerDTO));
        Assertions.assertTrue(personService.checkedUserName("asd"));
        Mockito.when(customerRepo.save(customer)).thenReturn(customer);
        customerDTO.setPersonId(person.getId());

        Assertions.assertEquals(customerDTO.getId(), customerService.dtoFromCustomer(customer).getId());
        Assertions.assertEquals(customerDTO.getPersonId(), customerService.dtoFromCustomer(customer).getPersonId());
        Assertions.assertEquals(customerDTO.getPhoneNumber(), customerService.dtoFromCustomer(customer).getPhoneNumber());
        Assertions.assertEquals(customerDTO.getEmail(), customerService.dtoFromCustomer(customer).getEmail());
        Assertions.assertEquals(customerDTO.getDateOfBirth(), customerService.dtoFromCustomer(customer).getDateOfBirth());
        Assertions.assertEquals(customerDTO.getSurname(), customerService.dtoFromCustomer(customer).getSurname());
        Assertions.assertEquals(customerDTO.getName(), customerService.dtoFromCustomer(customer).getName());
        Assertions.assertEquals(customerDTO.getUserName(), customerService.dtoFromCustomer(customer).getUserName());
        Assertions.assertEquals(customerDTO.getGender(), customerService.dtoFromCustomer(customer).getGender());
        Assertions.assertEquals(customerDTO.getRole(), customerService.dtoFromCustomer(customer).getRole());

        customerService.create(customerDTO);
        Mockito.verify(customerRepo, Mockito.times(1)).save(ArgumentMatchers.any(Customer.class));
    }

//    INCOMPLETE

//    @Test
    @DisplayName("Test for creating customer with duplicate username")
    public void testCreateWithDuplicateUsername(){
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(1L);
        customerDTO.setName("asd");
        customerDTO.setSurname("Asdyan");
        customerDTO.setGender("Female");
        customerDTO.setPhoneNumber("+374 0000");
        customerDTO.setDateOfBirth(new Date(1/1/2020));
        customerDTO.setEmail("asd@gmail.com");
        customerDTO.setUserName("asd");
        customerDTO.setPassword("ASD");
        customerDTO.setRole();

        Person person = new Person();
        person.setId(customerDTO.getId());
        person.setUserName(customerDTO.getUserName());
        person.setPassword(customerDTO.getPassword());
        person.setRole(customerDTO.getRole());

        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("asd");
        customer.setSurname("Asdyan");
        customer.setGender("Female");
        customer.setPhoneNumber("+374 0000");
        customer.setDateOfBirth(new Date(1/1/2020));
        customer.setEmail("asd@gmail.com");
        customer.setUserName("asd");
        customer.setPassword("ASD");
        customer.setPerson(person);

        Assertions.assertEquals(customer, customerService.customerFromDto(customerDTO));
        Assertions.assertFalse(personService.checkedUserName("asd"));
        Assertions.assertEquals(new CustomerDTO(), customerService.create(customerDTO));
        customerService.create(customerDTO);
    }

}