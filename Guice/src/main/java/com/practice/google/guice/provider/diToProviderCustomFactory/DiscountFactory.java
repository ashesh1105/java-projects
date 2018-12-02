package com.practice.google.guice.provider.diToProviderCustomFactory;

import com.google.inject.ImplementedBy;

@ImplementedBy(CartDiscountFactory.class)
public interface DiscountFactory {

    Discountable getDiscount(ShoppingCart shoppingCart);

}
