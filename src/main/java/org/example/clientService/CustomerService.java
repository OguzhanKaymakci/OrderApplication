package org.example.clientService;

import org.example.clientInt.CustomerInt;
import org.example.mainApp.Main;
import org.example.model.Customer;
import org.example.model.Invoice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CustomerService implements CustomerInt {


    protected List<Customer> customers= new ArrayList<>();

    @Override
    public void ListOfAllCustomer(List<Customer> ls) {

        List<Customer> ls2= (ls.stream().collect(Collectors.toList()));
        System.out.println(ls2);

    }

    @Override
    public void AddNewCustomer(List<Customer> ls, String name, String surName, int registerDate, String sector, Double amount, int invoiceDate) {
        ls.add(new Customer(name,surName,registerDate,sector));
        ls.get(0).addInvoice(new Invoice(amount,invoiceDate));

        List<Customer> ls2= (ls.stream().collect(Collectors.toList()));
        System.out.println(ls2);

    }

    @Override
    public void CustomerWithLetterC(List<Customer> ls) {
        List<Customer> ls2=new ArrayList<>();

        System.out.println("Customer With Letter C");

        for (Customer item:ls
             ) {
            if (item.getName().contains("c")){
                ls2.add(item);
            }else if (item.getSurName().contains("c")){
                ls2.add(item);
            };

            System.out.println(ls2);
        }}
}
