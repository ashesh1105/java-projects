package com.practice.google.guice.provider.diIntoProvider;

public class NoDiscount implements Discountable {
    public double getDiscount() {
        return 0.00;
    }
}
