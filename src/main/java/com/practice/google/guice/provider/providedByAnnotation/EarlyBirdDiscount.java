package com.practice.google.guice.provider.providedByAnnotation;

public class EarlyBirdDiscount implements Discountable {

    public double getDiscount() {
        return 0.25;
    }
}
