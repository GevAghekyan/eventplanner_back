package com.example.backeventplanner.persistence.event;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepo extends JpaRepository<Event, Long> {

    List<Event> findByEmployees_Id(Long id);

    List<Event> findAllByCustomer_Id(Long customerId);
}
