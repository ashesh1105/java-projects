package com.practice.google.guice.provider.providesAnnotation;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import java.time.LocalTime;

public class DiscountGuiceModule extends AbstractModule {
    @Override
    protected void configure() {

        // Note that you don't need to bind anything since you're using @Provides annotation below
        // Also note that get() method below don't even need to be public!
//        bind(Discountable.class).toProvider(DiscountProvider.class);
    }

    @Provides
    private Discountable get() {
        int hour = LocalTime.now().getHour();

        if (isEarlyMorning(hour)) {
            return new EarlyBirdDiscount();
        } else if (isLateNight(hour)) {
            return new NightOwlDiscount();
        }

        return new NoDiscount();
    }

    private boolean isLateNight(int currentHour) {
        return currentHour >= 0 && currentHour <= 4;
    }

    private boolean isEarlyMorning(int currentHour) {
        return currentHour >= 5 && currentHour <= 9;
    }
}
