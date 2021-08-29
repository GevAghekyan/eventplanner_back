package com.example.backeventplanner.facade.customer;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Date;

public class CustomerDTO {

    private Long id;
    private String name;
    private String surname;
    private String gender;
    private String phoneNumber;
    private Date dateOfBirth;
    private String email;
    private String userName;
    private String password;
    private String role;
    private Long personId;
    private final PasswordEncoder encoder = new BCryptPasswordEncoder();

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password != null) {
            this.password = encoder.encode(password);
        }
    }

    public Long getPersonId() {
        return personId;
    }

    public String getRole() {
        return role;
    }

    public void setRole() {
        this.role = "ROLE_USER";
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }
}
