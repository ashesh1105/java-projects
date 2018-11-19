package com.practice.google.guice.provider.diToProviderCustomFactory;

public class NoDiscount implements Discountable {
    public double getDiscount() {
        return 0.00;
    }
}
