package com.example.backeventplanner.persistence.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {

    @Query(value = "SELECT price FROM employee where id = :id", nativeQuery = true)
    Integer findPriceById(@Param("id") Long id);

    Employee findByUserName(String userName);
}
