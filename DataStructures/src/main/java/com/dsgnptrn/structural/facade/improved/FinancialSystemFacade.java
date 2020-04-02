package com.dsgnptrn.structural.facade.improved;

public class FinancialSystemFacade {

    private BillingSystem billingSystem = new BillingSystem();
    private InvoiceCustomerSystem invoiceCustomerSystem = new InvoiceCustomerSystem();

    public void createInvoice(Double amount) {
        Bill bill = billingSystem.createBill(amount);
        invoiceCustomerSystem.createInvoiceForBill(bill);
    }

    public void setBillingSystem(BillingSystem billingSystem) {
        this.billingSystem = billingSystem;
    }

    public void setInvoiceCustomerSystem(InvoiceCustomerSystem invoiceCustomerSystem) {
        this.invoiceCustomerSystem = invoiceCustomerSystem;
    }

}
