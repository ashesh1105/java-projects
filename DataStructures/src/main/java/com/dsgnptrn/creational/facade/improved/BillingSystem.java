package com.dsgnptrn.creational.facade.improved;

public class BillingSystem {
	
	public Bill createBill(Double amount) {
		return new Bill(amount);
	}

}
