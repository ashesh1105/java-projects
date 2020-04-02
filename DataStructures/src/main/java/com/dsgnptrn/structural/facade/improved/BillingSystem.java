package com.dsgnptrn.structural.facade.improved;

public class BillingSystem {

    public Bill createBill(Double amount) {
        return new Bill(amount);
    }

}