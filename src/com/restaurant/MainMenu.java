package com.restaurant;

/**
 * @author Mahsa Alikhani m-58
 */
public enum MainMenu {
    MANAGER("1) login as manager"),
    CUSTOMER("2) login as customer"),
    EXIT("3) Exit");

    private String expression;

    MainMenu(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    public static void showMainMenu(){
        System.out.println("***Welcome to restaurant system***");
        for (MainMenu element : MainMenu.values()) {
            System.out.println(element.getExpression());
        }
    }
}
