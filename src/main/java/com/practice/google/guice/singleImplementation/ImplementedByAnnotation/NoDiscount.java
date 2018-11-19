package com.practice.google.guice.singleImplementation.ImplementedByAnnotation;

public class NoDiscount implements Discountable {
    public double getDiscount() {
        return 0.00;
    }
}
