package com.restaurant;

import java.util.Scanner;

/**
 * @author Mahsa Alikhani m-58 - pset HW3 - Q#1: restaurant
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddCustomer addCustomer = new AddCustomer();
        Dinner dinner = new Dinner();
        Lunch lunch = new Lunch();
        String choice;
        do {
            MainMenu.showMainMenu();
            do {
                choice = scanner.next();
            } while (!choice.matches("[1-9]+"));

            switch ( Integer.parseInt(choice)) {
                case 1:
                    ManagerMenu.showManagerMenu();
                    String managerChoice;
                    do {
                        managerChoice = scanner.next();
                    } while (!managerChoice.matches("[1-9]+"));

                    switch (Integer.parseInt(managerChoice)) {
                        case 1:
                            while (true) {
                                DinnerOrLunch.showDinnerOrLunch();
                                String dinnerLunch;
                                do {
                                    dinnerLunch = scanner.next();
                                } while (!dinnerLunch.matches("[1-9]+"));
                                if (Integer.parseInt(dinnerLunch) == 3) { //exit
                                    break;
                                }
                                FoodOrDrink.showFoodOrDrink();
                                String fooDrink;
                                do {
                                    fooDrink = scanner.next();
                                } while (!fooDrink.matches("[1-9]+"));

                                String  id;
                                do {
                                    System.out.println("ID:");
                                    id = scanner.next();
                                } while (!id.matches("[1-9]+"));

                                String name;
                                do {
                                    System.out.println("Name:");
                                    name = scanner.next();
                                } while (!name.matches("[a-zA-Z]+"));
                                String price;
                                do {
                                    System.out.println("Price:");
                                    price = scanner.next();
                                } while (!price.matches("^[0-9]+(.|//)?[0-9]?$"));
                                String stock;
                                do {
                                    System.out.println("Stock:");
                                    stock = scanner.next();
                                } while (!stock.matches("[1-9]+"));
                                if (Integer.parseInt(dinnerLunch) == 1) { //dinner
                                    if (Integer.parseInt(fooDrink) == 1) { //food
                                        dinner.addToMenu(Long.parseLong(id), name, Double.parseDouble(price), Integer.parseInt(stock), FoodOrDrink.FOOD);
                                    } else if (Integer.parseInt(fooDrink) == 2) { //drink
                                        dinner.addToMenu(Long.parseLong(id), name, Double.parseDouble(price), Integer.parseInt(stock), FoodOrDrink.DRINK);
                                    }

                                } else if (Integer.parseInt(dinnerLunch) == 2) { //lunch
                                    if (Integer.parseInt(fooDrink) == 1) { //food
                                        lunch.addToMenu(Long.parseLong(id), name, Double.parseDouble(price), Integer.parseInt(stock), FoodOrDrink.FOOD);
                                    } else if (Integer.parseInt(fooDrink) == 2) { //drink
                                        lunch.addToMenu(Long.parseLong(id), name, Double.parseDouble(price), Integer.parseInt(stock), FoodOrDrink.DRINK);
                                    }
                                }
                            }
                            break;
                        case 2:
                            if (AddCustomer.customerIndex == 0) {
                                System.out.println("There is no customer!");
                            } else {
                                addCustomer.printCustomerInfo();
                            }
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Invalid value!");
                    }
                    break;
                case 2:
                    String firstName;
                    do {
                        System.out.println("First Name:");
                        firstName = scanner.next();
                    } while (!firstName.matches("[a-zA-Z]+"));

                    String secondName;
                    do {
                        System.out.println("Second Name:");
                        secondName = scanner.next();
                    } while (!secondName.matches("[a-zA-Z]+"));

                    String gender;
                    do {
                        System.out.println("Gender:");
                        gender = scanner.next();
                    } while (!gender.matches("\\b(?:male|Male|female|Female)\\b"));

                    String phoneNumber;
                    do {
                        System.out.println("Phone Number like 0912***3583/+98912***3583:");
                        phoneNumber = scanner.next();
                    } while (!phoneNumber.matches("^(\\+98|0)?9\\d{9}$"));

                    addCustomer.addNewCustomer(firstName, secondName, gender, phoneNumber);

                    CustomerMenu.showCustomerMenu();
                    String customerChoice;
                    do {
                        customerChoice = scanner.next();
                    } while (!customerChoice.matches("[1-9]+"));

                    long orderId;
                    switch (Integer.parseInt(customerChoice)) {
                        case 1:
                            DinnerOrLunch.showDinnerOrLunch();
                            String dinnerLunch;
                            do {
                                dinnerLunch = scanner.next();
                            } while (!dinnerLunch.matches("[1-9]+"));

                            if (Integer.parseInt(dinnerLunch) == 1) { //dinner
                                if (Dinner.drinkIndex == 0 && Dinner.foodIndex == 0) {
                                    System.out.println("There is no defined menu!");
                                } else if (Dinner.drinkIndex == 0) {
                                    System.out.println("Dinner Menu");
                                    dinner.printFoodMenu();
                                    System.out.println("There is no defined Drink Menu!");
                                    System.out.println("Which one do you want to order?");
                                    System.out.println("Enter your order ID:");
                                    orderId = scanner.nextInt();
                                    dinner.addNewOrder(orderId);
                                } else if (Dinner.foodIndex == 0) {
                                    System.out.println("Dinner Menu");
                                    dinner.printDrinkMenu();
                                    System.out.println("There is no defined Food Menu!");
                                    System.out.println("Which one do you want to order?");
                                    System.out.println("Enter your order ID:");
                                    orderId = scanner.nextInt();
                                    dinner.addNewOrder(orderId);
                                } else {
                                    System.out.println("Dinner Menu");
                                    dinner.printFoodMenu();
                                    dinner.printDrinkMenu();
                                    System.out.println("Which one do you want to order?");
                                    System.out.println("Enter your order ID:");
                                    orderId = scanner.nextInt();
                                    dinner.addNewOrder(orderId);
                                }
                            } else if (Integer.parseInt(dinnerLunch) == 2) { //lunch
                                if (Lunch.drinkIndex == 0 && Lunch.foodIndex == 0) {
                                    System.out.println("There is no defined menu!");
                                } else if (Lunch.drinkIndex == 0) {
                                    System.out.println("Lunch Menu");
                                    lunch.printFoodMenu();
                                    System.out.println("There is no defined Drink Menu!");
                                    System.out.println("Which one do you want to order?");
                                    System.out.println("Enter your order ID:");
                                    orderId = scanner.nextInt();
                                    lunch.addNewOrder(orderId);
                                } else if (Lunch.foodIndex == 0) {
                                    System.out.println("Lunch Menu");
                                    lunch.printDrinkMenu();
                                    System.out.println("There is no defined Food Menu!");
                                    System.out.println("Which one do you want to order?");
                                    System.out.println("Enter your order ID:");
                                    orderId = scanner.nextInt();
                                    lunch.addNewOrder(orderId);
                                } else {
                                    System.out.println("Lunch Menu");
                                    lunch.printFoodMenu();
                                    lunch.printDrinkMenu();
                                    System.out.println("Which one do you want to order?");
                                    System.out.println("Enter your order ID:");
                                    orderId = scanner.nextInt();
                                    lunch.addNewOrder(orderId);
                                }
                            }
                            break;
                        case 2:
                            DinnerOrLunch.showDinnerOrLunch();
                            do {
                                dinnerLunch = scanner.next();
                            } while (!dinnerLunch.matches("[1-9]+"));

                            if (Integer.parseInt(dinnerLunch) == 1) { //dinner
                                dinner.showOrderDetails(Integer.parseInt(dinnerLunch));
                            } else if (Integer.parseInt(dinnerLunch) == 2) { //lunch
                                lunch.showOrderDetails(Integer.parseInt(dinnerLunch));
                            }
                            break;
                        case 3:
                            DinnerOrLunch.showDinnerOrLunch();
                            do {
                                dinnerLunch = scanner.next();
                            } while (!dinnerLunch.matches("[1-9]+"));

                            if (Integer.parseInt(dinnerLunch) == 1){ //dinner
                                dinner.showOrderDetails(Integer.parseInt(dinnerLunch));
                                System.out.println("Enter cancellation Id:");
                                long id = scanner.nextLong();
                                dinner.cancelOrder(id);
                            }else if (Integer.parseInt(dinnerLunch) == 2){ //lunch
                                lunch.showOrderDetails(Integer.parseInt(dinnerLunch));
                                System.out.println("Enter cancellation Id:");
                                long id = scanner.nextLong();
                                lunch.cancelOrder(id);
                            }
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Invalid value!");
                    }
                    break;
                case 3:
                    System.out.println("***Goodbye***");
                    break;
                default:
                    System.out.println("Invalid value!");
            }
        } while (Integer.parseInt(choice) != 3);
    }
}
