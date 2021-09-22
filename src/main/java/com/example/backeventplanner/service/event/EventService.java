package com.example.backeventplanner.service.event;


import com.example.backeventplanner.facade.event.EventDTO;

import java.util.ArrayList;

public interface EventService {

    EventDTO create(EventDTO dto);

    EventDTO getById(Long id);

    ArrayList<EventDTO> findAllByCustomerId(Long customerId);

    ArrayList<EventDTO> findAllByEventId(Long employeeId);

    ArrayList<EventDTO> getAll();

    EventDTO updateById(Long id, EventDTO dto);

    void deleteById(Long id);

}
