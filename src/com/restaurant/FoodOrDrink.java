package com.restaurant;

/**
 * @author Mahsa Alikhani m-58
 */
public enum FoodOrDrink {
    FOOD("1) Food"),
    DRINK("2) Drink");

    String expression;

    FoodOrDrink(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    public static void showFoodOrDrink(){
        for (FoodOrDrink item : FoodOrDrink.values()) {
            System.out.println(item.getExpression());
        }
    }
}
