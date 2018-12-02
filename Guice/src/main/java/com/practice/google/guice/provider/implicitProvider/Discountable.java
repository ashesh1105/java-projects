package com.practice.google.guice.provider.implicitProvider;

import com.google.inject.ImplementedBy;

@ImplementedBy(NoDiscount.class)
public interface Discountable {
    double getDiscount();
}
