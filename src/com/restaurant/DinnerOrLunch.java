package com.restaurant;/**
 * @author Mahsa Alikhani m-58
 */public enum DinnerOrLunch {
    DINNER("1) Dinner"),
    LUNCH("2) Lunch"),
    EXIT("3) Exit");

    String expression;

    DinnerOrLunch(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    public static void showDinnerOrLunch(){
        for (DinnerOrLunch item : DinnerOrLunch.values()) {
            System.out.println(item.getExpression());
        }
    }
}
