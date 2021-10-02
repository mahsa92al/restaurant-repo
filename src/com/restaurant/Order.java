package com.restaurant;

/**
 * @author Mahsa Alikhani m-58 - pset HW3 - Q#1: restaurant
 */
enum OrderStatus {
    RESERVED, CANCELED
}

public class Order {
    private long orderId;
    private String OrderName;
    private double orderPrice;
    private OrderStatus status;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return OrderName;
    }

    public void setOrderName(String orderName) {
        OrderName = orderName;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

}
