package com.example.backeventplanner.facade.portfolio;

public class PortfolioDTO {

    private Long id;
    private String name;
    private String url;
    private Long employeeId;

    public PortfolioDTO() {
    }

    public PortfolioDTO(Long id, String name, String url, Long employeeId) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.employeeId = employeeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "PortfolioDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", employeeId=" + employeeId +
                '}';
    }
}
