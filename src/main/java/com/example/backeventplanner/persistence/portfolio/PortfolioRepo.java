package com.example.backeventplanner.persistence.portfolio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PortfolioRepo extends JpaRepository<Portfolio,Long> {

    @Query(value = "SELECT url FROM portfolio where employee_id = :id and name = 'logo' ", nativeQuery = true)
    String findLogoByEmployeeId(@Param("id") Long id);

    @Query(value = "SELECT url FROM portfolio where employee_id = :id and name = 'image' ", nativeQuery = true)
    String findImageByEmployeeId(@Param("id") Long id);


}
