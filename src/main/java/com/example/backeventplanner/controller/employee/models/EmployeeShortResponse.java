package com.example.backeventplanner.controller.employee.models;

public class EmployeeShortResponse {

    private Long id;
    private String companyName;
    private Integer price;
    private String logoUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    @Override
    public String toString() {
        return "EmployeeShortResponse{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", price=" + price +
                ", logoUrl='" + logoUrl + '\'' +
                '}';
    }
}
