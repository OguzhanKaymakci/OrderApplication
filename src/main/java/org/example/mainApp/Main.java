package org.example.mainApp;

import org.example.clientInt.CustomerInt;
import org.example.clientService.CustomerService;
import org.example.model.Customer;
import org.example.model.Invoice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CustomerService customerService= new CustomerService();
        //add customer
        List<Customer> lsCustomer= new ArrayList<>();
        lsCustomer.add(new Customer("Ali","Bilir",7,"DOC"));
        lsCustomer.add(new Customer("Ayşe","Bilmez",10,"LAWYER"));
        lsCustomer.add(new Customer("Mehmet","Bilirler",3,"NURSE"));
        lsCustomer.add(new Customer("Fatma","Bilcezler",11,"TEACHER"));
        lsCustomer.add(new Customer("Hasancan","Bilmezler",7,"POET"));

        //add invoice
        lsCustomer.get(0).addInvoice(new Invoice(2000.,8));
        lsCustomer.get(0).addInvoice(new Invoice(2500.,8));
        lsCustomer.get(1).addInvoice(new Invoice(1500.,11));
        lsCustomer.get(1).addInvoice(new Invoice(1650.,11));
        lsCustomer.get(2).addInvoice(new Invoice(350.,4));
        lsCustomer.get(2).addInvoice(new Invoice(550.,4));
        lsCustomer.get(3).addInvoice(new Invoice(800.,12));
        lsCustomer.get(3).addInvoice(new Invoice(750.,12));
        lsCustomer.get(4).addInvoice(new Invoice(1200.,8));
        lsCustomer.get(4).addInvoice(new Invoice(900.,8));


        //All customers
        customerService.ListOfAllCustomer(lsCustomer);
        //Add new customer
        Scanner scanner= new Scanner(System.in);
        System.out.println("please press 1 If you want add new customer ");
        int number=scanner.nextInt();
        if (number==1){
            System.out.println("Please enter Name?");
            String name= scanner.nextLine();
            System.out.println("Surname");
            String surname= scanner.nextLine();
            System.out.println("sector");
            String sector= scanner.nextLine();
            System.out.println("amount Of invoice");
            Double amount= scanner.nextDouble();
            System.out.println("registerDate(Just Mounth)");
            int registerDate= scanner.nextInt();
            System.out.println("invoiceDate(Just Mounth)");
            int invoiceDate= scanner.nextInt();
            customerService.AddNewCustomer(lsCustomer,name,surname,registerDate,sector,amount,invoiceDate);
        }



        //list of inculude c in name
        customerService.CustomerWithLetterC(lsCustomer);
    }
}
