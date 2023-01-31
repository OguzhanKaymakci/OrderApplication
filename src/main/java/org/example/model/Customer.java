package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String surName;
    private int registerDate;
    private String sector;
    private List<Invoice> invoices = new ArrayList<>();

    public Customer(String name, String surName, int registerDate, String sector) {
        this.name = name;
        this.surName = surName;
        this.registerDate = registerDate;
        this.sector = sector;
    }


    // Dışarıdan list in içerisine atmak için
    public void addInvoice(Invoice invoice) {
        invoices.add(invoice);
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(int registerDate) {
        this.registerDate = registerDate;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", registerDate=" + registerDate +
                ", sector='" + sector + '\'' +
                ", invoices=" + invoices +
                '}';
    }
}
