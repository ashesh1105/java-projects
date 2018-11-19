package com.practice.google.guice.provider.implicitProvider;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * This class is same as package singleImplementation.ImplementedByAnnotation except that we are using Guice to inject
 * Provider<Discountable> in Checkout Service. Then using the get() factory method in Checkoutservice to extract
 * Discountable Implementation from the Provider. This is implicit provider implementation where:
 * you get lazy instantiation of underlying implementation specified by:
 *      1) GuiceModule -> using bind().to() method
 *      2) Or @ImplementedBy annotation specified on interface. Former has priority over later one.
 *
 * Limitation here is that we still have to know the dependencies in advance. Can not use one based on runtime.
 * Checkout explicitProvider package for this where we specify our own Provider.
 */

public class MainClassWithImplicitProvider {

    public static void main(String[] args) {

        // No binding is necessary in GuiceModule if we use @ImplementedBy on Interfaces themselves
        Injector guice = Guice.createInjector(new DiscountGuiceModule());

        // The annotation @ImplementedBy on Discountable interface specifies the implementation to be injected in CheckoutService
        CheckoutService service = guice.getInstance(CheckoutService.class);
        service.checkout(100.00);
    }

}
