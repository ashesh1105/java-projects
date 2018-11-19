package com.practice.google.guice.provider.implicitProvider;

public class EarlyBirdDiscount implements Discountable {

    public double getDiscount() {
        return 0.25;
    }
}
