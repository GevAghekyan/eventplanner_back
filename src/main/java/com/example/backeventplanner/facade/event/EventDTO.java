package com.example.backeventplanner.facade.event;

import com.example.backeventplanner.persistence.employee.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.util.ArrayList;
import java.util.UUID;

public class EventDTO {

    private Long id;
    private String type;
    private Date date;
    private String description;
    private UUID serialNumber;
    private Integer price;
    private Long customerId;
    private ArrayList<Long> employeeIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber() {
        this.serialNumber = UUID.randomUUID();
    }

    public void setSerialNumber(UUID serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public ArrayList<Long> getEmployeeIds() {
        return employeeIds;
    }

    public void setEmployeeIds(ArrayList<Long> employeeIds) {
        this.employeeIds = employeeIds;
    }

    @Override
    public String toString() {
        return "EventDTO{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", serialNumber=" + serialNumber +
                ", price=" + price +
                ", customerId=" + customerId +
                ", employeeIds=" + employeeIds +
                '}';
    }
}
