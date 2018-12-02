package com.practice.google.guice.provider.diToProviderCustomFactory;

import com.google.inject.Inject;

public class CheckoutService {

    // Notice, we are using DiscountFactory here, to be injected by Guice instead of Discountable itself
    private DiscountFactory discountFactory;

    @Inject
    public CheckoutService(DiscountFactory discountFactory) {
        this.discountFactory = discountFactory;
    }

    public double checkout(ShoppingCart cart) {

        Discountable discountable = discountFactory.getDiscount(cart);

        double shoppingCartTotal = cart.getShoppingCartTotal();
        double totalAfterDiscount = shoppingCartTotal - (shoppingCartTotal * discountable.getDiscount());
        System.out.printf("%nShopping Cart initially [$%.2f], with a discount of %.2f%% = [$%.2f]",
                shoppingCartTotal, 100 * discountable.getDiscount(), totalAfterDiscount);

        return totalAfterDiscount;
    }

}
