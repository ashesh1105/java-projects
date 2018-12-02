package com.practice.google.guice.provider.diIntoProvider;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * In this package, we are injecting into Provider, DiscountProvider. Unlike other packages, here Provider is not
 * using a local variable like LocalTime.now().getHour() to decide which Discountable implementation to inject, here
 * we have a more real-life situation where:
 * a) We get user inputs or some events that trigger the need for a specific implementation to be injected,
 * b) We do not have to clutter the code, i.e., Provider class, etc., with all the possible implementations.
 *
 * Here, we configure a MapBinder object of type <Integer, Discountable> and bind all possible implementations of
 * Discountable with an integer as key. Guice injects this map into Provider at runtime. We then look up this map
 * based on an even triggered (here, it is Random, but can be any other inputs) to inject specific implementations
 * into CheckoutService which is then injected into MainAppWithCustomFactory which is used to start the application.
 * So, it is much more dynamic and close to real life situation.
 *
 * Also, note that we bind a MapBinder with a plain Map in GuiceModule here, and that allows us to use plain Map
 * to be injected and used in look-up for a specific implementation in our Provider, the DiscountProvider.
 * MapBinder is NOT a map! It becomes a map when Binder converts this into a Map and injects into Provider.
 */

public class BasicApplication {

    private final CheckoutService checkoutService;

    @Inject
    public BasicApplication(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    void start() {
        checkoutService.checkout(100.0D);
    }

    public static void main(String[] args) {

        // Creates overall object graph
        Injector guice = Guice.createInjector(new DiscountGuiceModule());

        // Creates separate object graph with business logic, etc. Instantiate the main object on that
        BasicApplication application = guice.getInstance(BasicApplication.class);

        // Start your app
        application.start();
    }

}
