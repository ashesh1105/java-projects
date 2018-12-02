package com.practice.google.guice.provider.explicitProvider;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Here, we are using our own provider as DiscountProvider class which implements Provider of type Discountable.
 * Provider Interface has one method to be overridden which is get() which returns a specific implementation
 * based on a runtime variable, which is hour of the day based on LocalTime.
 *
 * With above, in the GuiceModule, we bind to a provider: bind(Discountable.class).toProvider(DiscountProvider.class)
 *
 * With above arrangement, we can use any runtime situation and have Guice inject an implementation accordingly.
 *
 * Note that since we are using Provider, we are also taking advantage of late instantiation.
 *
 * Also note that if you don't need lazy instantiation, you can directly use the Discountable interface in this example.
 * See CheckoutService where we commented out the Provider related implementation and right implementation is injected
 * during runtime.
 */

public class MainClassWithExplicitProvider {

    public static void main(String[] args) {

        Injector guice = Guice.createInjector(new DiscountGuiceModule());

        CheckoutService service = guice.getInstance(CheckoutService.class);
        service.checkOut(100.00);
    }

}
