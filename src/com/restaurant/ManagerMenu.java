package com.restaurant;

import java.util.Scanner;

/**
 * @author Mahsa Alikhani m-58
 */
public enum ManagerMenu {
    ADD("1) Add to menu"),
    CUSTOMER("2) Customer info"),
    BACK("3) Back to main menu");

    private String expression;

    ManagerMenu(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    public static void showManagerMenu(){
        System.out.println("***Manager Menu***");
        for (ManagerMenu element : ManagerMenu.values()) {
            System.out.println(element.getExpression());
        }
    }

    public static void getManagerInputs(){
        Scanner scanner = new Scanner(System.in);
        int managerChoice;
        do {
            managerChoice = scanner.nextInt();
        } while (!(Integer.toString(managerChoice)).matches("[0-9]+"));
    }
}
