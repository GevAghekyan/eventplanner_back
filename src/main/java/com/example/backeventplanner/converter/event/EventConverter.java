package com.example.backeventplanner.converter.event;

import com.example.backeventplanner.controller.event.models.EventRequestModel;
import com.example.backeventplanner.controller.event.models.EventResponseModel;
import com.example.backeventplanner.facade.event.EventDTO;

public interface EventConverter {
    EventDTO dtoFromRequest(EventRequestModel requestModel);

    EventResponseModel responseFromDto(EventDTO dto);
}
