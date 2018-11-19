package com.practice.google.guice.provider.providesAnnotation;

public class EarlyBirdDiscount implements Discountable {

    public double getDiscount() {
        return 0.25;
    }
}
