package com.restaurant;

/**
 * @author Mahsa Alikhani m-58 - pset HW3 - Q#1: restaurant
 */
public class AddCustomer {
    Customer[] customers = new Customer[1000];
    static int customerIndex = 0;

    /*public AddCustomer() {
        for (int i = 0; i < 1000; i++) {
            customers[i] = new Customer();
        }
    }*/


    public void addNewCustomer(String firstName, String secondName, String gender, String phoneNumber) {
        customers[customerIndex] = new Customer(firstName, secondName, gender, phoneNumber);
       /* customers[customerIndex].setFirstName(firstName);
        customers[customerIndex].setSecondName(secondName);
        customers[customerIndex].setGender(gender);
        customers[customerIndex].setPhoneNumber(phoneNumber);*/
        customerIndex++;
    }

    public void printCustomerInfo() {
        for (int i = 0; i < customerIndex; i++) {
            System.out.println(customers[i].getFirstName() + " " + customers[i].getSecondName() + " "
                    + customers[i].getGender() + " " + customers[i].getPhoneNumber());
        }
    }
}
