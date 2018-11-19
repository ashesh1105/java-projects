package com.practice.google.guice.singleImplementation.ImplementedByAnnotation;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Single Implementation package demonstrates Guice behavior when you know the dependency upfront and
 *  bind a specific implementation to the interface by:
 *  a) in GuiceModule (DiscountGuiceModule here)
 *  b) add a default implementation on interface itself by using @ImplementedBy
 *  If you do both of above, GuiceModule binding will win.
 *
 * This package demonstrates @ImplementedBy applied to an interface.
 * Note that if you have this annotation on interface and also have binding specified in GuiceModule,
 * the binding in GuiceModule will win. Its useful when you want to specify default implementation with @ImplementedBy
 * and specify the actual binding using GuiceModule. Check Discountable Interface and DiscoutGuice Module in this package.
 */

public class MainClassWithImplementedBy {

    public static void main(String[] args) {

        // No binding is necessary in GuiceModule if we use @ImplementedBy on Interfaces themselves
        Injector guice = Guice.createInjector(new DiscountGuiceModule());

        // The annotation @ImplementedBy on Discountable interface specifies the implementation to be injected in CheckoutService
        CheckoutService service = guice.getInstance(CheckoutService.class);
        service.checkout(100.00);
    }

}
