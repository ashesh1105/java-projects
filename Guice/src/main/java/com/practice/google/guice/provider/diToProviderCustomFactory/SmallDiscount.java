package com.practice.google.guice.provider.diToProviderCustomFactory;

public class SmallDiscount implements Discountable {

    public double getDiscount() {
        return 0.05;
    }
}
