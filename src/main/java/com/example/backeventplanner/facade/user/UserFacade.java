package com.example.backeventplanner.facade.user;

import com.example.backeventplanner.annotation.Facade;
import com.example.backeventplanner.controller.user.UserResponseModel;
import com.example.backeventplanner.facade.customer.CustomerDTO;
import com.example.backeventplanner.facade.employee.EmployeeDTO;
import com.example.backeventplanner.facade.event.EventDTO;
import com.example.backeventplanner.service.customer.CustomerService;
import com.example.backeventplanner.service.employee.EmployeeService;
import com.example.backeventplanner.service.event.EventService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

@Facade
public class UserFacade {

    private final EmployeeService employeeService;
    private final CustomerService customerService;
    private final EventService eventService;

    @Autowired
    public UserFacade(EmployeeService employeeService, CustomerService customerService, EventService eventService) {
        this.employeeService = employeeService;
        this.customerService = customerService;
        this.eventService = eventService;
    }

    public UserResponseModel get(String userName) {
        UserResponseModel userResponseModel = new UserResponseModel();
        EmployeeDTO employeeDTO = employeeService.findByUserName(userName);
        if (employeeDTO.getId() != null){
            userResponseModel.setUserName(employeeDTO.getUserName());
            userResponseModel.setOccupation(employeeDTO.getSpecialist());
            ArrayList<EventDTO> allByEmployeeId = eventService.findAllByEventId(employeeDTO.getId());
            for (int i = 0; i < allByEmployeeId.size(); i++) {
                userResponseModel.getEventNames()[i] = allByEmployeeId.get(i).getDescription();
            }
        } else {
            CustomerDTO customerDTO = customerService.findByUserName(userName);
            userResponseModel.setUserName(customerDTO.getUserName());
            ArrayList<EventDTO> allByCustomerId = eventService.findAllByCustomerId(customerDTO.getId());
            for (int i = 0; i < allByCustomerId.size(); i++) {
                userResponseModel.getEventNames()[i] = allByCustomerId.get(i).getDescription();
            }
        }
        return userResponseModel;
    }
}
