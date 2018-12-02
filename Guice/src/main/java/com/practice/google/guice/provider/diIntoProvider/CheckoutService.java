package com.practice.google.guice.provider.diIntoProvider;

import com.google.inject.Inject;

public class CheckoutService {

    private Discountable discountable;

    @Inject
    public CheckoutService(Discountable discountable) {
        this.discountable = discountable;
    }

    public double checkout(double shoppingCarttotal) {

        double totalAfterDiscount = shoppingCarttotal - (shoppingCarttotal * discountable.getDiscount());
        System.out.printf("%nShopping Cart initially [$%.2f], with a discount of %.2f%% = [$%.2f]",
                shoppingCarttotal, shoppingCarttotal * discountable.getDiscount(), totalAfterDiscount);

        return totalAfterDiscount;
    }

}
