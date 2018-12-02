package com.practice.google.guice.provider.providedByAnnotation;

public class NightOwlDiscount implements Discountable {
    public double getDiscount() {
        return 0.35;
    }
}
