package com.example.backeventplanner.service.employee;

import com.example.backeventplanner.facade.employee.EmployeeDTO;
import com.example.backeventplanner.persistence.employee.Employee;
import com.example.backeventplanner.persistence.employee.EmployeeRepo;
import com.example.backeventplanner.persistence.person.Person;
import com.example.backeventplanner.service.person.PersonService;
import com.example.backeventplanner.service.portfolio.PortfolioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepo employeeRepo;

    @Mock
    private PersonService personService;

    @Mock
    private PortfolioService portfolioService;

    private EmployeeService employeeService;

    @BeforeEach
    void setUp(){
        employeeService = new EmployeeServiceImpl(employeeRepo,personService,portfolioService);
    }

    @Test
    void create() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(1L);
        employeeDTO.setPassword("pass");
        boolean check = true;
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setPassword("pass");
        employee.setPerson(new Person());
        Mockito.when(personService.checkedUserName(employeeDTO.getUserName())).thenReturn(check);
        Mockito.when(employeeRepo.save(employee)).thenReturn(employee);
        EmployeeDTO employeeDTO1 = employeeService.create(employeeDTO);
        Mockito.verify(employeeRepo,Mockito.times(1)).save(ArgumentMatchers.any(Employee.class));
        Assertions.assertEquals(employeeDTO1.getId(),employee.getId());
    }

//    public EmployeeDTO create(EmployeeDTO dto) {
//        Employee employee = employeeFromDto(dto);
//        Boolean check = personService.checkedUserName(dto.getUserName());
//        if (check) {
//            Employee saved = employeeRepo.save(employee);
//            return dtoFromEmployee(saved);
//        }
//        return new EmployeeDTO();
//    }
}