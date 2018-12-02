package com.practice.google.guice.singleImplementation.explicitBindViaGuiceModule;

import com.google.inject.AbstractModule;

public class DiscountGuiceModule extends AbstractModule {
    @Override
    protected void configure() {

        // This is where you tell Guice how to wire up your dependencies
        bind(Discountable.class).to(NightOwlDiscount.class);
    }
}
