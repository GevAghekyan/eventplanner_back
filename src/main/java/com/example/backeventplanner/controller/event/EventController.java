package com.example.backeventplanner.controller.event;

import com.example.backeventplanner.controller.event.models.EventRequestModel;
import com.example.backeventplanner.controller.event.models.EventResponseModel;
import com.example.backeventplanner.facade.event.EventFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class EventController {

    private final EventFacade eventFacade;

    @Autowired
    public EventController(EventFacade eventFacade) {
        this.eventFacade = eventFacade;
    }

    @PostMapping("/event/create")
    public ResponseEntity<EventResponseModel> create(@RequestBody EventRequestModel requestModel) {
        EventResponseModel responseModel = eventFacade.create(requestModel);
        return ResponseEntity.ok(responseModel);
    }

    @GetMapping("/event/create/{id}")
    public ResponseEntity<EventResponseModel> getById(@PathVariable Long id) {
        EventResponseModel byId = eventFacade.getById(id);
        return ResponseEntity.ok(byId);
    }

    @GetMapping("/event/getAll")
    public ResponseEntity<ArrayList<EventResponseModel>> getAll() {
        ArrayList<EventResponseModel> all = eventFacade.getAll();
        return ResponseEntity.ok(all);
    }

    @PutMapping("/event/update/{id}")
    public ResponseEntity<EventResponseModel> updateById(@RequestBody EventRequestModel requestModel, @PathVariable Long id) {
        EventResponseModel responseModel = eventFacade.updateById(id, requestModel);
        return ResponseEntity.ok(responseModel);
    }

    @DeleteMapping("/event/delete/{id}")
    public void delete(@PathVariable Long id) {
        eventFacade.deleteById(id);
    }

}
