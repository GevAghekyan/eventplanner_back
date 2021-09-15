package com.example.backeventplanner.persistence.customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

    Customer findByUserName(String userName);

}
