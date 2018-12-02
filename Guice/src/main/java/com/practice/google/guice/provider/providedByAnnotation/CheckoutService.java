package com.practice.google.guice.provider.providedByAnnotation;

import com.google.inject.Inject;

public class CheckoutService {

    // Using Provider (commented as of now) helps on lazy instantiation, but you don't have to use it.
//    private Provider<Discountable> discountable;
    private Discountable discountable;

    @Inject // as specified by @ImplementedBy specified in Discountable interface
//    public CheckoutService(Provider<Discountable> discountable) {
    public CheckoutService(Discountable discountable) {
        this.discountable = discountable;
    }

    public double checkOut(double shoppingCarttotal) {

        // Use the commented line below if you are using Provider for lazy instantiation
//        double totalAfterDiscount = shoppingCarttotal - (shoppingCarttotal * discountable.get().getDiscount());
        double totalAfterDiscount = shoppingCarttotal - (shoppingCarttotal * discountable.getDiscount());
        System.out.printf("%nShopping Cart initially [$%.2f], with a discount of %.2f%% = [$%.2f]",
//                shoppingCarttotal, shoppingCarttotal * discountable.get().getDiscount(), totalAfterDiscount);
                shoppingCarttotal, shoppingCarttotal * discountable.getDiscount(), totalAfterDiscount);

        return totalAfterDiscount;
    }

}
