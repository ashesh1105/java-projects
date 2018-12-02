package com.practice.google.guice.provider.providedByAnnotation;

import com.google.inject.ProvidedBy;

@ProvidedBy(DiscountProvider.class)
public interface Discountable {
    double getDiscount();
}
