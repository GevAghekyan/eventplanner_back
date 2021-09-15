package com.example.backeventplanner.service.employee;

import com.example.backeventplanner.controller.employee.models.EmployeeShortResponse;
import com.example.backeventplanner.facade.employee.EmployeeDTO;
import com.example.backeventplanner.persistence.employee.Employee;
import com.example.backeventplanner.persistence.employee.EmployeeRepo;
import com.example.backeventplanner.persistence.person.Person;
import com.example.backeventplanner.service.person.PersonService;
import com.example.backeventplanner.service.portfolio.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;
    private final PersonService personService;
    private final PortfolioService portfolioService;


    @Autowired
    public EmployeeServiceImpl(EmployeeRepo employeeRepo, PersonService personService, PortfolioService portfolioService) {
        this.employeeRepo = employeeRepo;
        this.personService = personService;
        this.portfolioService = portfolioService;
    }

    @Override
    public EmployeeDTO create(EmployeeDTO dto) {
        Employee employee = employeeFromDto(dto);
        Boolean check = personService.checkedUserName(dto.getUserName());
        if (check) {
            Employee saved = employeeRepo.save(employee);
            return dtoFromEmployee(saved);
        }
        return new EmployeeDTO();
    }

    @Override
    public EmployeeDTO getById(Long id) {
        Employee byId = employeeRepo.getById(id);
        return dtoFromEmployee(byId);
    }

    @Override
    public List<EmployeeShortResponse> findAllBySpecialist(String specialist) {
        List<Employee> all = employeeRepo.findAllBySpecialist(specialist);
        List<EmployeeShortResponse> collect = all.stream()
                .map(employee -> employeeShortResponseFromEmployee(employee))
                .collect(Collectors.toList());
        return collect;
    }

    @Override
    public ArrayList<EmployeeDTO> getAll() {
        List<Employee> all = employeeRepo.findAll();
        List<EmployeeDTO> collect = all.stream()
                .map(each -> dtoFromEmployee(each))
                .collect(Collectors.toList());
        return (ArrayList<EmployeeDTO>) collect;
    }

    /*This method updates only info about employee
     * its not update username, password & role*/

    @Override
    public EmployeeDTO updateById(Long id, EmployeeDTO dto) {
        Employee byId = employeeRepo.getById(id);
        if (dto.getName() != null) byId.setName(dto.getName());
        if (dto.getSurname() != null) byId.setSurname(dto.getSurname());
        if (dto.getGender() != null) byId.setGender(dto.getGender());
        if (dto.getPhoneNumber() != null) byId.setPhoneNumber(dto.getPhoneNumber());
        if (dto.getEmail() != null) byId.setEmail(dto.getEmail());
        if (dto.getDateOfBirth() != null) byId.setDateOfBirth(dto.getDateOfBirth());
        if (dto.getSpecialist() != null) byId.setSpecialist(dto.getSpecialist());
        if (dto.getPrice() != null) byId.setPrice(dto.getPrice());
        if (dto.getAbout() != null) byId.setAbout(dto.getAbout());
        Employee saved = employeeRepo.save(byId);
        return dtoFromEmployee(saved);
    }

    @Override
    public void deleteById(Long id) {
        employeeRepo.deleteById(id);
    }

    private Employee employeeFromDto(EmployeeDTO dto) {
        Employee employee = new Employee();
        employee.setId(dto.getId());
        employee.setName(dto.getName());
        employee.setSurname(dto.getSurname());
        employee.setCompanyName(dto.getCompanyName());
        employee.setGender(dto.getGender());
        employee.setPhoneNumber(dto.getPhoneNumber());
        employee.setDateOfBirth(dto.getDateOfBirth());
        employee.setEmail(dto.getEmail());
        employee.setSpecialist(dto.getSpecialist());
        employee.setPrice(dto.getPrice());
        employee.setAbout(dto.getAbout());
        employee.setUserName(dto.getUserName());
        employee.setPassword(dto.getPassword());
        Person person = new Person();
        person.setId(dto.getPersonId());
        person.setUserName(dto.getUserName());
        person.setPassword(dto.getPassword());
        person.setRole(dto.getRole());
        employee.setPerson(person);
        return employee;
    }

    private EmployeeDTO dtoFromEmployee(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setSurname(employee.getSurname());
        employeeDTO.setCompanyName(employee.getCompanyName());
        employeeDTO.setGender(employee.getGender());
        employeeDTO.setPhoneNumber(employee.getPhoneNumber());
        employeeDTO.setDateOfBirth(employee.getDateOfBirth());
        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setSpecialist(employee.getSpecialist());
        employeeDTO.setPrice(employee.getPrice());
        employeeDTO.setAbout(employee.getAbout());
        employeeDTO.setUserName(employee.getUserName());
        employeeDTO.setPassword(employee.getPassword());
        employeeDTO.setRole();
        employeeDTO.setPersonId(employee.getPerson().getId());
        return employeeDTO;
    }

    private EmployeeShortResponse employeeShortResponseFromEmployee(Employee employee) {
        EmployeeShortResponse employeeShortResponse = new EmployeeShortResponse();
        employeeShortResponse.setId(employee.getId());
        employeeShortResponse.setCompanyName(employee.getCompanyName());
        employeeShortResponse.setPrice(employee.getPrice());
        String logoUrl = portfolioService.logoUrlByEmpId(employee.getId());
        employeeShortResponse.setLogoUrl(logoUrl);
        return employeeShortResponse;

    }

}
