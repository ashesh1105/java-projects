package com.practice.google.guice.singleImplementation.ImplementedByAnnotation;

public class NightOwlDiscount implements Discountable {
    public double getDiscount() {
        return 0.35;
    }
}
