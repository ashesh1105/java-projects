package com.practice.google.guice.provider.providesAnnotation;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * This is very similar to implementation in explicitProvider package except that we did not declare an explicit class
 * as Provider of Discountable type. Since we do not need to pass any runtime data to get() method of Provider and we
 * are using LocalTime to decide the implementation we need Guice to inject here, we can provide that get method inside
 * of our GuiceModule (DiscountGuiceModule) itself with an annotation @Provides. This way Guice knows how to get the
 * right implementation for Discountable and inject that in CheckoutService or anywhere else in the application.
 *
 * The get method with @Provides annotation don't even need to be public. It is private in this package and everything works!
 *
 * Also note that in the GuiceModule you don't need to bind anything in configure method since you're using @Provides
 * and Google Guice knows which implementation to inject that way.
 */

public class MainClassWithProvidesAnnotation {

    public static void main(String[] args) {

        Injector guice = Guice.createInjector(new DiscountGuiceModule());

        CheckoutService service = guice.getInstance(CheckoutService.class);
        service.checkOut(100.00);
    }

}
