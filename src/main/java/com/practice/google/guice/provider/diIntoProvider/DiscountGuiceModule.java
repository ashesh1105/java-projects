package com.practice.google.guice.provider.diIntoProvider;

import com.google.inject.AbstractModule;
import com.google.inject.Provider;
import com.google.inject.Provides;
import com.google.inject.multibindings.MapBinder;

import java.time.LocalTime;
import java.util.Random;

public class DiscountGuiceModule extends AbstractModule {

    @Override
    protected void configure() {

        // binder() returns Binder which binds MapBinder with a Map of Integer and Discountable
        // Notice that we are using plain Map in DiscountProvider and not really a MapBinder
        MapBinder<Integer, Discountable> mapBinder
                = MapBinder.newMapBinder(binder(), Integer.class, Discountable.class);

        mapBinder.addBinding(0).to(BigDiscount.class);
        mapBinder.addBinding(1).to(SmallDiscount.class);
        mapBinder.addBinding(2).to(NoDiscount.class);

        // Below is not necessary since we are using default constructor of Random to be injected into Provider Constructor.
        // This will be needed if we needed Guice to bind Random to a specific non-argument constructor based instance, l
        // ike new Random(10), for example.
        bind(Random.class).toInstance(new Random());

        // This tells Guice to call DiscountProvider's get() method to find an implementation for Discountable to be injected
        // into CheckoutService, which then is injected into MainAppWithCustomFactory. So explicit binding is needed here.
        bind(Discountable.class).toProvider(DiscountProvider.class);

    }
}
