package com.dsgnptrn.structural.facade;

public class BillingSystem {
	
	public Bill createBill(Double amount) {
		return new Bill(amount);
	}

}
