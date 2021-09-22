package com.example.backeventplanner.service.event;

import com.example.backeventplanner.facade.event.EventDTO;
import com.example.backeventplanner.persistence.customer.Customer;
import com.example.backeventplanner.persistence.customer.CustomerRepo;
import com.example.backeventplanner.persistence.employee.Employee;
import com.example.backeventplanner.persistence.employee.EmployeeRepo;
import com.example.backeventplanner.persistence.event.Event;
import com.example.backeventplanner.persistence.event.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepo eventRepo;
    private final CustomerRepo customerRepo;
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EventServiceImpl(EventRepo eventRepo, CustomerRepo customerRepo, EmployeeRepo employeeRepo) {
        this.eventRepo = eventRepo;
        this.customerRepo = customerRepo;
        this.employeeRepo = employeeRepo;
    }

    @Override
    public EventDTO create(EventDTO dto) {
        Event saved = eventRepo.save(eventFromDto(dto));
        return dtoFromEvent(saved);
    }

    @Override
    public EventDTO getById(Long id) {
        Event byId = eventRepo.getById(id);
        return dtoFromEvent(byId);
    }

    @Override
    public ArrayList<EventDTO> findAllByCustomerId(Long id) {
        List<Event> all = eventRepo.findAllByCustomer_Id(id);
        List<EventDTO> collect = all.stream()
                .map(each -> dtoFromEvent(each))
                .collect(Collectors.toList());
        return (ArrayList<EventDTO>) collect;
    }

    @Override
    public ArrayList<EventDTO> findAllByEventId(Long id) {
        List<Event> all = eventRepo.findByEmployees_Id(id);
        List<EventDTO> collect = all.stream()
                .map(each -> dtoFromEvent(each))
                .collect(Collectors.toList());
        return (ArrayList<EventDTO>) collect;
    }

    @Override
    public ArrayList<EventDTO> getAll() {
        List<Event> all = eventRepo.findAll();
        List<EventDTO> collect = all.stream()
                .map(each -> dtoFromEvent(each))
                .collect(Collectors.toList());
        return (ArrayList<EventDTO>) collect;
    }

    @Override
    public EventDTO updateById(Long id, EventDTO dto) {
        Event byId = eventRepo.getById(id);
        if (dto.getType() != null) byId.setType(dto.getType());
        if (dto.getDate() != null) byId.setDate(dto.getDate());
        if (dto.getDescription() != null) byId.setDescription(dto.getDescription());
        if (dto.getEmployeeIds() != null) {
            ArrayList<Long> employeeIds = dto.getEmployeeIds();
            List<Employee> collect = employeeIds.stream()
                    .map(each -> employeeRepo.getById(each))
                    .collect(Collectors.toList());
            byId.setEmployees(collect);
        }
        if (dto.getPrice() != null) byId.setPrice(dto.getPrice());
        Event saved = eventRepo.save(byId);
        return dtoFromEvent(saved);
    }

    @Override
    public void deleteById(Long id) {
        eventRepo.deleteById(id);

    }

    private Event eventFromDto(EventDTO dto) {
        Event event = new Event();
        event.setId(dto.getId());
        event.setType(dto.getType());
        event.setDate(dto.getDate());
        event.setDescription(dto.getDescription());
        event.setSerialNumber(dto.getSerialNumber());
        event.setPrice(dto.getPrice());
        Customer customer = customerRepo.getById(dto.getCustomerId());
        event.setCustomer(customer);
        ArrayList<Long> employeeIds = dto.getEmployeeIds();
        List<Employee> collect = employeeIds.stream()
                .map(each -> employeeRepo.getById(each))
                .collect(Collectors.toList());
        event.setEmployees(collect);
        return event;
    }

    private EventDTO dtoFromEvent(Event event) {
        EventDTO eventDTO = new EventDTO();
        eventDTO.setId(event.getId());
        eventDTO.setType(event.getType());
        eventDTO.setDate(event.getDate());
        eventDTO.setDescription(event.getDescription());
        eventDTO.setSerialNumber(event.getSerialNumber());
        eventDTO.setPrice(event.getPrice());
        eventDTO.setCustomerId(event.getCustomer().getId());
        List<Employee> employees = event.getEmployees();
        List<Long> employeeIds = employees.stream()
                .map(each -> each.getId())
                .collect(Collectors.toList());
        eventDTO.setEmployeeIds((ArrayList<Long>) employeeIds);
        return eventDTO;

    }
}
