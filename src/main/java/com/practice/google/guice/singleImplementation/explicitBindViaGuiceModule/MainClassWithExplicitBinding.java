package com.practice.google.guice.singleImplementation.explicitBindViaGuiceModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Single Implementation package demonstrates Guice behavior when you know the dependency upfront and
 * bind a specific implementation to the interface by:
 * a) in GuiceModule (DiscountGuiceModule here) in this package or
 * b) add a default implementation on interface itself by using @ImplementedBy
 * If you do both of above, GuiceModule binding will win.
 */

public class MainClassWithExplicitBinding {

    public static void main(String[] args) {

        // You configure Guice in GuiceModule that defines binding of a specific implementation
        Injector guice = Guice.createInjector(new DiscountGuiceModule());

        // Guice injects an implementation of Discountable in CheckoutService before instantiating that
        // based on binding defined in GuiceModule. Check DiscountGuiceModule in this case
        CheckoutService service = guice.getInstance(CheckoutService.class);
        service.checkout(100.00);
    }

}
