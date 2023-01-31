package org.example.clientInt;

import org.example.model.Customer;

import java.util.List;

public interface CustomerInt {
    public void ListOfAllCustomer(List<Customer> ls);
    public void AddNewCustomer(List<Customer> ls,String name, String surName,int registerDate,String sector,Double amount,int invoiceDate );
    public void CustomerWithLetterC(List<Customer> ls);
}

