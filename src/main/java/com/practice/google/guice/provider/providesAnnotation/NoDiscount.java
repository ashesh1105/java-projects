package com.practice.google.guice.provider.providesAnnotation;

public class NoDiscount implements Discountable {
    public double getDiscount() {
        return 0.00;
    }
}
