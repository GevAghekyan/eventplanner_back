package com.example.backeventplanner.controller.event.models;

import java.sql.Date;
import java.util.ArrayList;

public class EventRequestModel {
    private String type;
    private Date date;
    private String description;
    private Long customerId;
    private Integer price;
    private ArrayList<Long> employeeIds;

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

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
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

    @Override
    public String toString() {
        return "EventRequestModel{" +
                "type='" + type + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", customerId=" + customerId +
                ", price=" + price +
                ", employeeIds=" + employeeIds +
                '}';
    }
}
