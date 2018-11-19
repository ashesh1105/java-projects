package com.practice.google.guice.provider.providedByAnnotation;

import com.google.inject.AbstractModule;

public class DiscountGuiceModule extends AbstractModule {
    @Override
    protected void configure() {

        // You don't need to bind anything here since you're using @ProvidedBy annotation on interface Discountable
//        bind(Discountable.class).toProvider(DiscountProvider.class);
    }
}
