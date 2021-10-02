package com.restaurant;

/**
 * @author Mahsa Alikhani m-58 - pset HW3 - Q#1: restaurant
 */
public class Dinner extends Meal {

    @Override
    public void addToMenu(long id, String name, double price, int stock, FoodOrDrink fooDrink) {
        super.addToMenu(id, name, price, stock, fooDrink);
    }

    @Override
    public void printFoodMenu() {
        super.printFoodMenu();
    }

    @Override
    public void printDrinkMenu() {
        super.printDrinkMenu();
    }

    @Override
    public void addNewOrder(long id) {
        super.addNewOrder(id);
    }

    @Override
    public void showOrderDetails(int type) {
        super.showOrderDetails(type);
    }

    @Override
    public void cancelOrder(long id) {
        super.cancelOrder(id);
    }
}
