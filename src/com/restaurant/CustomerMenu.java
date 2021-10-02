package com.restaurant;

/**
 * @author Mahsa Alikhani m-58
 */
public enum CustomerMenu {
    ADD("1) Add new order"),
    SHOW("2) Show orders details"),
    CANCEL("3) Cancel an order"),
    BACK("4) Back to main menu");

    String expression;

    CustomerMenu(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    public static void showCustomerMenu(){
        System.out.println("***Customer Menu***");
        for (CustomerMenu element : CustomerMenu.values()) {
            System.out.println(element.getExpression());
        }
    }
}
