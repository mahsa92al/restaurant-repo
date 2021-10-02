package com.restaurant;

/**
 * @author Mahsa Alikhani m-58 - pset HW3 - Q#1: restaurant
 */

public class Meal extends FoodDrink {

    FoodDrink[] foods = new FoodDrink[100];
    static int foodIndex = 0;

    FoodDrink[] drinks = new FoodDrink[100];
    static int drinkIndex = 0;

    Order[] orders = new Order[100];
    static int orderIndex = 0;

    public Meal() {
        for (int i = 0; i < 100; i++) {
            foods[i] = new FoodDrink();
            drinks[i] = new FoodDrink();
            orders[i] = new Order();
        }
    }

    public void addToMenu(long id, String name, double price, int stock, FoodOrDrink fooDrink) {
        if (fooDrink.equals(FoodOrDrink.FOOD)) {
            foods[foodIndex].setID(id);
            foods[foodIndex].setName(name);
            foods[foodIndex].setPrice(price);
            foods[foodIndex].setStock(stock);
            foodIndex++;
        } else if (fooDrink.equals(FoodOrDrink.DRINK)) {
            drinks[drinkIndex].setID(id);
            drinks[drinkIndex].setName(name);
            drinks[drinkIndex].setPrice(price);
            drinks[drinkIndex].setStock(stock);
            drinkIndex++;
        }
    }

    public void printFoodMenu() {
        System.out.println("Foods:");
        for (int i = 0; i < foodIndex; i++) {
            System.out.println(foods[i].getID() + " " + foods[i].getName() + " " + foods[i].getPrice() + " T");
        }

    }

    public void printDrinkMenu() {
        System.out.println("Drinks:");
        for (int i = 0; i < drinkIndex; i++) {
            System.out.println(drinks[i].getID() + " " + drinks[i].getName() + " " + drinks[i].getPrice() + " T");
        }
    }

    public void addNewOrder(long id) {

        for (int i = 0; i < foodIndex; i++) {
            if (foods[i].getID() == id) {
                if (foods[i].getStock() == 0) {
                    System.out.println("Your order ran out! Make another order.");
                }else {
                    orders[orderIndex].setOrderId(id);
                    orders[orderIndex].setOrderName(foods[i].getName());
                    orders[orderIndex].setOrderPrice(foods[i].getPrice());
                    orders[orderIndex].setStatus(OrderStatus.RESERVED);
                    orderIndex++;

                    foods[i].setStock(foods[i].getStock() - 1);
                    break;
                }
            }
        }
        for (int i = 0; i < drinkIndex; i++) {
            if (drinks[i].getID() == id) {
                if (drinks[i].getStock() == 0) {
                    System.out.println("Your order ran out! Make another order.");
                }else {
                    orders[orderIndex].setOrderId(id);
                    orders[orderIndex].setOrderName(drinks[i].getName());
                    orders[orderIndex].setOrderPrice(drinks[i].getPrice());
                    orders[orderIndex].setStatus(OrderStatus.RESERVED);
                    orderIndex++;

                    drinks[i].setStock(drinks[i].getStock() - 1);
                    break;
                }
            }
        }
        if (orderIndex != 0) {
            System.out.print(orders[0].getOrderName());
            for (int i = 1; i < orderIndex; i++) {
                System.out.print(" & " + orders[i].getOrderName());
            }
            System.out.println(" has successfully added to your order.");
        }
    }

    public Double calculateTotalPriceOrder(double tax) {
        double totalPrice = 0;
        if (orderIndex != 0) {
            for (int i = 0; i < orderIndex; i++) {
                totalPrice = totalPrice + orders[i].getOrderPrice();
            }
            return totalPrice + totalPrice * tax;
        }
        return null;
    }

    public void showOrderDetails(int type) {
        for (int i = 0; i < orderIndex; i++) {
            System.out.print(orders[i].getOrderId() + " , " + orders[i].getOrderName() + " , " + orders[i].getStatus() + " ");
            if(type == 1){ //dinner
                System.out.println(calculateTotalPriceOrder(0.15) + " ," + "Tax = %15");
            }else if(type == 2){
                System.out.println(calculateTotalPriceOrder(0.10) + " ," + "Tax = %10");
            }
        }
    }

    public void cancelOrder(long id) {

        if (orderIndex != 0) {
            for (int i = 0; i < orderIndex; i++) {
                System.out.println(orders[i].getOrderName() + ", " + orders[i].getOrderId()
                        + ", " + orders[i].getStatus());

                if (orders[i].getOrderId() == id) {
                    orders[i].setStatus(OrderStatus.CANCELED);
                    addStock(id);
                    System.out.println(orders[i].getOrderName() + ", " + orders[i].getOrderId()
                            + ", " + orders[i].getStatus());
                }
            }
        } else {
            System.out.println("There is no order for you!");
        }
    }

    public void addStock(long cancelId) {
        for (int i = 0; i < Meal.foodIndex; i++) {
            if (foods[i].getID() == cancelId) {
                foods[i].setStock(foods[i].getStock() + 1);
            }
        }
        for (int i = 0; i < Meal.drinkIndex; i++) {
            if (drinks[i].getID() == cancelId) {
                drinks[i].setStock(drinks[i].getStock() + 1);
            }
        }
    }
}
