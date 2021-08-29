package com.example.backeventplanner.facade.event;

import com.example.backeventplanner.annotation.Facade;
import com.example.backeventplanner.controller.event.models.EventRequestModel;
import com.example.backeventplanner.controller.event.models.EventResponseModel;
import com.example.backeventplanner.converter.EventConverter;
import com.example.backeventplanner.persistence.employee.EmployeeRepo;
import com.example.backeventplanner.service.event.EventService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Facade
public class EventFacade {

    private final EventConverter eventConverter;
    private final EventService eventService;
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EventFacade(EventConverter eventConverter, EventService eventService, EmployeeRepo employeeRepo) {
        this.eventConverter = eventConverter;
        this.eventService = eventService;
        this.employeeRepo = employeeRepo;
    }

    public EventResponseModel create(EventRequestModel requestModel) {
        EventDTO dto = eventConverter.dtoFromRequest(requestModel);
        ArrayList<Long> employeeIds = requestModel.getEmployeeIds();
        Integer price = employeeIds.stream()
                .map(each -> employeeRepo.findPriceById(each))
                .mapToInt(Integer::valueOf)
                .sum();
        dto.setPrice(price);
        EventDTO saved = eventService.create(dto);
        return eventConverter.responseFromDto(saved);
    }

    public EventResponseModel getById(Long id) {
        EventDTO byId = eventService.getById(id);
        return eventConverter.responseFromDto(byId);
    }

    public ArrayList<EventResponseModel> getAll() {
        ArrayList<EventDTO> all = eventService.getAll();
        List<EventResponseModel> collect = all.stream()
                .map(each -> eventConverter.responseFromDto(each))
                .collect(Collectors.toList());
        return (ArrayList<EventResponseModel>) collect;
    }

    public EventResponseModel updateById(Long id, EventRequestModel requestModel) {
        EventDTO saved = eventService.updateById(id, eventConverter.dtoFromRequest(requestModel));
        return eventConverter.responseFromDto(saved);
    }

    public void deleteById(Long id) {
        eventService.deleteById(id);
    }
}
