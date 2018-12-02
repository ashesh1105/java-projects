package com.dsgnptrn.creational.facade.improved;

public class Client {

	/*
	 * Facade Pattern is intended to provide a uniform interface to a set of interfaces in a subsystem. Facade defines a
	 * higher level interface that makes the subsystem easier to use. 1) Client will only know the Facade. 2) Facade is
	 * part of the system, i.e., it knows how the system works.
	 * 
	 * Usage: 1) Decouples clients from subsystem, 2) Provides simple interface, 3) If we want to have Subsystem
	 * layering (Business, Data and Client Services) and each of these layers provide a facade to other layer.
	 * 
	 * Structure: 1) Facade knows the subsystem, 2) It is subsystem access point, 3) Simply delegates to subsystem
	 * implementing the functionality. 4) Facade by itself never implements the functionality by itself: Client ->
	 * Facade -> Subsystem. 5) Helps extra loose coupling since Clients don't need to access the subsystem directly.
	 * 
	 * *** Most Important point *** : Clients, if needed CAN CALL the Subsystems directly too (say for performance
	 * reasons), unlike Adapter Pattern where Client is incompatible with subsystem interface so we must need an
	 * adapter!
	 * 
	 * ** Drawbacks ** Facade introduces extra programming layer so always use your judgment if facade is going to add
	 * value by abstract a complex system from a client or not.
	 * 
	 * *** Examples from Java Libraries:
	 * https://stackoverflow.com/questions/1673841/examples-of-gof-design-patterns-in-javas-core-libraries/2707195
	 */

	public static void main(String[] args) {

		BillingSystem billingSystem = new BillingSystem();
		InvoiceCustomerSystem invoiceCustomerSystem = new InvoiceCustomerSystem();

		FinancialSystemFacade facade = new FinancialSystemFacade();
		facade.setBillingSystem(billingSystem);
		facade.setInvoiceCustomerSystem(invoiceCustomerSystem);

		facade.createInvoice(1000.00);

		/*
		 * See the advantages above where new client (this) does not need to know if there are 100 methods to be
		 * involved on subsystem and all it needs to know is which facade to initialize and use to create the invoice!
		 */

	}

}
