package com.example.backeventplanner.controller.event.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.UUID;

public class EventResponseModel {

    private Long id;
    private String type;
    private Date date;
    private String description;
    private UUID serialNumber;
    private Integer price;
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

    public void setSerialNumber(UUID serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public ArrayList<Long> getEmployeeIds() {
        return employeeIds;
    }

    public void setEmployeeIds(ArrayList<Long> employeeIds) {
        this.employeeIds = employeeIds;
    }
}
