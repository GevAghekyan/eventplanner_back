package com.example.backeventplanner.controller.user;

import java.util.Arrays;

public class UserResponseModel {

    private String userName;
    private String occupation;
    private String[] eventNames = new String[10];

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String[] getEventNames() {
        return eventNames;
    }

    public void setEventNames(String[] eventNames) {
        this.eventNames = eventNames;
    }

    @Override
    public String toString() {
        return "UserResponseModel{" +
                "userName='" + userName + '\'' +
                ", occupation='" + occupation + '\'' +
                ", eventNames=" + Arrays.toString(eventNames) +
                '}';
    }
}
