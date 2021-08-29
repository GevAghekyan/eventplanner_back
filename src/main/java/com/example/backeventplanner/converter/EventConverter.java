package com.example.backeventplanner.converter;

import com.example.backeventplanner.annotation.Converter;
import com.example.backeventplanner.controller.event.models.EventRequestModel;
import com.example.backeventplanner.controller.event.models.EventResponseModel;
import com.example.backeventplanner.facade.event.EventDTO;

@Converter
public class EventConverter {

    public EventDTO dtoFromRequest(EventRequestModel requestModel){
        EventDTO eventDTO = new EventDTO();
        eventDTO.setType(requestModel.getType());
        eventDTO.setDate(requestModel.getDate());
        eventDTO.setDescription(requestModel.getDescription());
        eventDTO.setSerialNumber();
        eventDTO.setCustomerId(requestModel.getCustomerId());
        eventDTO.setEmployeeIds(requestModel.getEmployeeIds());
        return eventDTO;
    }

    public EventResponseModel responseFromDto(EventDTO dto){
        EventResponseModel eventResponseModel = new EventResponseModel();
        eventResponseModel.setId(dto.getId());
        eventResponseModel.setType(dto.getType());
        eventResponseModel.setDate(dto.getDate());
        eventResponseModel.setDescription(dto.getDescription());
        eventResponseModel.setSerialNumber(dto.getSerialNumber());
        eventResponseModel.setPrice(dto.getPrice());
        eventResponseModel.setEmployeeIds(dto.getEmployeeIds());
        return eventResponseModel;
    }
}
