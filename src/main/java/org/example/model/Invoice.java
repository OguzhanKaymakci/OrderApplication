package org.example.model;

public class Invoice {
    private double amount;
    private int invoiceDate;


    public Invoice() {
    }

    public Invoice(Double amount, int invoiceDate) {
        this.amount = amount;
        this.invoiceDate = invoiceDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(int invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "amount=" + amount +
                ", invoiceDate=" + invoiceDate +
                '}';
    }


}
