package com.practice.google.guice.singleImplementation.ImplementedByAnnotation;

import com.google.inject.ImplementedBy;

@ImplementedBy(NoDiscount.class)
public interface Discountable {
    double getDiscount();
}
