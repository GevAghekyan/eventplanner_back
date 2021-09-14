package com.example.backeventplanner.converter.event;
import java.util.UUID;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;

import com.example.backeventplanner.controller.event.models.EventRequestModel;
import com.example.backeventplanner.controller.event.models.EventResponseModel;
import com.example.backeventplanner.facade.event.EventDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventConverterImplTest {
    private EventConverterImpl eventConverter;

    @BeforeEach
    private void setUp(){
        eventConverter = new EventConverterImpl();
    }

    @Test
    public void testDtoFromRequest(){
        EventRequestModel eventRequestModel = new EventRequestModel();
        eventRequestModel.setType("Custom");
        eventRequestModel.setDate(new Date(1/1/2020));
        eventRequestModel.setDescription("aaaaaaaa");
        eventRequestModel.setPrice(1000);
        ArrayList<Long> employeesId = new ArrayList<>();
        employeesId.add(1L);
        employeesId.add(2L);
        employeesId.add(3L);
        eventRequestModel.setEmployeeIds(employeesId);

        EventDTO eventDTO = eventConverter.dtoFromRequest(eventRequestModel);
        Assertions.assertEquals(eventRequestModel.getType(), eventDTO.getType());
        Assertions.assertEquals(eventRequestModel.getDate(), eventDTO.getDate());
        Assertions.assertEquals(eventRequestModel.getDescription(), eventDTO.getDescription());
        Assertions.assertEquals(eventRequestModel.getPrice(), eventDTO.getPrice());
        Assertions.assertEquals(eventRequestModel.getEmployeeIds(), eventDTO.getEmployeeIds());
    }

    @Test
    public void testResponseFromDto(){
        EventDTO eventDTO = new EventDTO();
        eventDTO.setId(1L);
        eventDTO.setType("Custom");
        eventDTO.setDate(new Date(2/2/2020));
        eventDTO.setDescription("aaaaaaaa");
        eventDTO.setSerialNumber();
        eventDTO.setPrice(100000);
        ArrayList<Long> employeesId = new ArrayList<>();
        employeesId.add(1L);
        employeesId.add(2L);
        employeesId.add(3L);
        eventDTO.setEmployeeIds(employeesId);

        EventResponseModel event = eventConverter.responseFromDto(eventDTO);
        Assertions.assertEquals(eventDTO.getType(), event.getType());
        Assertions.assertEquals(eventDTO.getDescription(), event.getDescription());
        Assertions.assertEquals(eventDTO.getDate(), event.getDate());
        Assertions.assertEquals(eventDTO.getId(), event.getId());
        Assertions.assertEquals(eventDTO.getPrice(), event.getPrice());
        Assertions.assertEquals(eventDTO.getSerialNumber(), event.getSerialNumber());
        Assertions.assertEquals(eventDTO.getEmployeeIds(), event.getEmployeeIds());
    }

}