package com.practice.google.guice.provider.diIntoProvider;


import com.google.inject.Inject;
import com.google.inject.Provider;

import java.util.Map;
import java.util.Random;

public class DiscountProvider implements Provider<Discountable> {

    private Random random;
    private Map<Integer, Discountable> mapBinder;   // Notice, this is a plain Map and not MapBinder

    @Inject
    public DiscountProvider(Random random, Map<Integer, Discountable> mapBinder) {
        this.random = random;
        this.mapBinder = mapBinder;
    }

    @Override
    public Discountable get() {
        return mapBinder.get(random.nextInt(mapBinder.size()));
    }
}
