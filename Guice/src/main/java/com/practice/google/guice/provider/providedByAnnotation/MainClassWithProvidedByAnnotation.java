package com.practice.google.guice.provider.providedByAnnotation;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * This package is very similar to explicitProvider one except that we are not binding anything here and using
 * @ProvidedBy annotation on our interface Discountable and telling it to use DiscountProvider as Provider.
 * Hence we do not need to bind any provider in GuiceModule and the DI still happens.
 */

public class MainClassWithProvidedByAnnotation {

    public static void main(String[] args) {

        Injector guice = Guice.createInjector(new DiscountGuiceModule());

        CheckoutService service = guice.getInstance(CheckoutService.class);
        service.checkOut(100.00);
    }

}
