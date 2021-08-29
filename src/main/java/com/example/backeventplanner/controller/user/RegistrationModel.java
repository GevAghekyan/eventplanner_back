package com.example.backeventplanner.controller.user;

import java.io.File;
import java.sql.Date;

public class RegistrationModel {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String gender;
    private Date date;
    private String username;
    private String password;
    private String confirmPassword;
    private String role;
    private String occupation;
    private String companyName;
    private File image1;
    private File image2;
    private File image3;
    private File image4;
    private Integer price;
    private String description;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public File getImage1() {
        return image1;
    }

    public void setImage1(File image1) {
        this.image1 = image1;
    }

    public File getImage2() {
        return image2;
    }

    public void setImage2(File image2) {
        this.image2 = image2;
    }

    public File getImage3() {
        return image3;
    }

    public void setImage3(File image3) {
        this.image3 = image3;
    }

    public File getImage4() {
        return image4;
    }

    public void setImage4(File image4) {
        this.image4 = image4;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "RegistrationModel{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                ", date=" + date +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", role='" + role + '\'' +
                ", occupation='" + occupation + '\'' +
                ", companyName='" + companyName + '\'' +
                ", image1=" + image1 +
                ", image2=" + image2 +
                ", image3=" + image3 +
                ", image4=" + image4 +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
