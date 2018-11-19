package com.practice.google.guice.singleImplementation.explicitBindViaGuiceModule;

public class EarlyBirdDiscount implements Discountable {

    public double getDiscount() {
        return 0.25;
    }
}
