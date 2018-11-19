package com.practice.google.guice.provider.implicitProvider;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class CheckoutService {

    private Provider<Discountable> discountable;

    @Inject // as specified by @ImplementedBy specified in Discountable interface
    public CheckoutService(Provider<Discountable> discountable) {
        this.discountable = discountable;
    }

    public double checkout(double shoppingCarttotal) {
        double totalAfterDiscount = shoppingCarttotal - (shoppingCarttotal * discountable.get().getDiscount());
        System.out.printf("%nShopping Cart initially [$%.2f], with a discount of %.2f%% = [$%.2f]",
                shoppingCarttotal, shoppingCarttotal * discountable.get().getDiscount(), totalAfterDiscount);

        return totalAfterDiscount;
    }

}
