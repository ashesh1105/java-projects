package com.practice.google.guice.provider.diToProviderCustomFactory;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.Map;

@Singleton
public class CartDiscountFactory implements DiscountFactory {

    private final Map<DiscountOption, Discountable> discountableBinder;

    @Inject
    public CartDiscountFactory(Map<DiscountOption, Discountable> mapBinder) {
        this.discountableBinder = mapBinder;
    }

    @Override
    public Discountable getDiscount(ShoppingCart cart) {

        int currentHour = cart.getTimeOfCheckout().getHour();

        if (isEarlyMorning(currentHour)) {
            return discountableBinder.get(DiscountOption.EarlyBird);
        } else if (isLateNight(currentHour)) {
            return discountableBinder.get(DiscountOption.NightOwl);
        }

        return discountableBinder.get(DiscountOption.ZeroDiscount);
    }

    private boolean isEarlyMorning(int currentHour) {
        return currentHour >= 5 && currentHour <= 9;
    }

    private boolean isLateNight(int currentHour) {
        return currentHour >= 0 && currentHour <= 4;
    }
}
