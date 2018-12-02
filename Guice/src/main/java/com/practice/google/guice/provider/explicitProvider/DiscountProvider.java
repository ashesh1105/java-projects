package com.practice.google.guice.provider.explicitProvider;


import com.google.inject.Provider;

import java.time.LocalTime;

public class DiscountProvider implements Provider<Discountable> {

    public Discountable get() {
        int hour = LocalTime.now().getHour();

        if (isEarlyMorning(hour)) {
            return new EarlyBirdDiscount();
        } else if (isLateNight(hour)){
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
