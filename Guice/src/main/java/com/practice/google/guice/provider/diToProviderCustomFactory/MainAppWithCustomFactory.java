package com.practice.google.guice.provider.diToProviderCustomFactory;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import java.time.LocalTime;
import java.util.Scanner;

/**
 * Please see diIntoProvider prior to this.
 *
 * You can not pass runtime data into a Provider since Provider's get method does not take any parameter. To overcome
 * this limitation, we need to roll out own Factory. This is how code executes in this package:
 *
 * 1) We tell Guice to inject CheckoutService instance in this main app.
 * 1.a) CheckoutService has an instance variable of type DiscountFactory, which we tell Guice to inject into the service instance
 * 1.b) DiscountFactory is an interface with @ImplementedBy with CartDiscountFactory which implements DiscountFactory
 * 1.c) DiscountFactory has a get method that takes (runtime parameter) as ShoppingCart and returns Discountable.
 * 1.d) Our Guice Module, DiscountGuiceModule, leverages MapBinder to bind an Enum, DiscountOption, with Discountable.
 * 1.e) Above step allows Guice to inject a (plain map) into CartDiscountFactory while instantiating it (nested instantiation).
 * 2) Main app takes user inputs and constructs ShoppingCart to simulate a real checkout scenario.
 * 3) Main app calls checkout on CheckoutService instance as many times user wants to checkout.
 * 4) checkout method of CheckoutService calls get(ShoppingCart cart) on CartDiscountFactory to get an implementation of Discountable
 * 5) CartDiscountFactory can have get method which takes parameter since it is our own factory and does not implement Provider.
 * 6) CartDiscountFactory checks the hour associated with ShoppingCart and returns a Discountable based on time of day it is.
 * 7) CheckoutService then does the rest of work in checkout flow (here, just printing the details).
 */

public class MainAppWithCustomFactory {

    private final CheckoutService checkoutService;

    @Inject
    public MainAppWithCustomFactory(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    void start() {

        boolean ready = true;

        Scanner scanner = new Scanner(System.in);

        while (ready) {

            checkoutService.checkout(getNewUserShoppingCart(scanner));

            // Take user input if (s)he wants to checkout again
            System.out.println("\nDo you wish to checkout again? (y/n): ");
            if (scanner.next().equals("n")) {
                ready = false;
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {

        // Creates overall object graph
        Injector guice = Guice.createInjector(new DiscountGuiceModule());

        // Creates separate object graph with business logic, etc. Instantiate the main object on that
        MainAppWithCustomFactory application = guice.getInstance(MainAppWithCustomFactory.class);

        // Start your app
        application.start();
    }

    // *** User Inputs Code Below *** //

    private ShoppingCart getNewUserShoppingCart(Scanner scanner) {

        ShoppingCart shoppingCart = new ShoppingCart(
                getShoppingCartTotalFromUserInput(scanner),
                getLocalTimeFromUserInput(scanner)
        );

        return shoppingCart;
    }

    private double getShoppingCartTotalFromUserInput(Scanner scanner) {

        System.out.println("Please enter Shopping Cart Total (numbers only): ");
        return scanner.nextDouble();
    }

    private LocalTime getLocalTimeFromUserInput(Scanner scanner) {

        int hourOfDay = 0;
        int minuteOfDay = 0;

        System.out.println("Please enter hour of day it is (numbers only 0 to 23): ");
        hourOfDay = scanner.nextInt();
        while (!(hourOfDay < 24 && hourOfDay >= 0)) {
            System.out.println("Please enter hour of day between and including 0 and 23 only: ");
            hourOfDay = scanner.nextInt();
        }


        System.out.println("Please enter minute of hour it is (numbers only 0 to 60): ");
        minuteOfDay = scanner.nextInt();
        while (!(minuteOfDay <= 60 && minuteOfDay >= 0)) {
            System.out.println("Please enter minute of hour between and including 0 and 60 only: ");
            minuteOfDay = scanner.nextInt();
        }

        return LocalTime.of(hourOfDay, minuteOfDay);
    }

}
