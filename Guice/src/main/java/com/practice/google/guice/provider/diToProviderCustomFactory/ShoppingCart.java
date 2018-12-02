package com.practice.google.guice.provider.diToProviderCustomFactory;

import java.time.LocalTime;

public class ShoppingCart {

    private double shoppingCartTotal;
    private LocalTime timeOfCheckout;

    public ShoppingCart(double shoppingCartTotal, LocalTime localTime) {
        this.shoppingCartTotal = shoppingCartTotal;
        this.timeOfCheckout = localTime;
    }

    public ShoppingCart() {

    }

    public double getShoppingCartTotal() {
        return shoppingCartTotal;
    }

    public void setShoppingCartTotal(double shoppingCartTotal) {
        this.shoppingCartTotal = shoppingCartTotal;
    }

    public LocalTime getTimeOfCheckout() {
        return timeOfCheckout;
    }

    public void setTimeOfCheckout(LocalTime timeOfCheckout) {
        this.timeOfCheckout = timeOfCheckout;
    }
}
