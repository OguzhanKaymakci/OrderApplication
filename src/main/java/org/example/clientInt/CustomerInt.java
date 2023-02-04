package org.example.clientInt;

import org.example.model.Customer;

import java.util.List;

public interface CustomerInt {
    public void ListOfAllCustomer(List<Customer> ls);
    public void newCustomer(List<Customer> ls);
    public void CustomerWithLetterC(List<Customer> ls);
    public void registerDateJuneTotalAmount(List<Customer> ls);
    public void listOfAllInvoices(List<Customer> ls);
    public void invoicesOver1500TL(List<Customer> ls);
    public void avarageOfInvoicesOver1500TL(List<Customer> ls);
    public void listOfCustomerNamesOfInvoicesUnder500TL(List<Customer> ls);
    public void listOfSector(List<Customer> ls);
}

