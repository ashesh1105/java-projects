package com.practice.google.guice.provider.diToProviderCustomFactory;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;

import java.util.Random;

public class DiscountGuiceModule extends AbstractModule {

    @Override
    protected void configure() {

        // binder() returns Binder which binds MapBinder with a Map of DiscountOption and Discountable
        // Notice that we are using plain Map in CartDiscountFactory and not really a MapBinder
        MapBinder<DiscountOption, Discountable> mapBinder
                = MapBinder.newMapBinder(binder(), DiscountOption.class, Discountable.class);

        mapBinder.addBinding(DiscountOption.EarlyBird).to(SmallDiscount.class);
        mapBinder.addBinding(DiscountOption.NightOwl).to(BigDiscount.class);
        mapBinder.addBinding(DiscountOption.ZeroDiscount).to(NoDiscount.class);

    }
}
