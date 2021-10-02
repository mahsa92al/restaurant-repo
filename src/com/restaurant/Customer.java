package com.restaurant;

/**
 * @author Mahsa Alikhani m-58 - pset HW3 - Q#1: restaurant
 */
public class Customer {
    private String firstName;
    private String secondName;
    private String gender;
    private String phoneNumber;

    public Customer(String firstName, String secondName, String gender, String phoneNumber) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    public Customer() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
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
}
