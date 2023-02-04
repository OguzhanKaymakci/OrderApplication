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
        lsCustomer.add(new Customer("Can","Bilir",7,"DOC"));
        lsCustomer.add(new Customer("Ayşe","Bilmez",10,"LAWYER"));
        lsCustomer.add(new Customer("Mehmet","Bilirler",6,"NURSE"));
        lsCustomer.add(new Customer("Fatma","Bilcezler",11,"TEACHER"));
        lsCustomer.add(new Customer("Hasancan","Bilmezler",6,"POET"));

        //add invoice
        lsCustomer.get(0).addInvoice(new Invoice(2000.,8));
        lsCustomer.get(0).addInvoice(new Invoice(200.,8));
        lsCustomer.get(1).addInvoice(new Invoice(1500.,11));
        lsCustomer.get(1).addInvoice(new Invoice(1650.,11));
        lsCustomer.get(2).addInvoice(new Invoice(350.,4));
        lsCustomer.get(2).addInvoice(new Invoice(450.,4));
        lsCustomer.get(3).addInvoice(new Invoice(500.,6));
        lsCustomer.get(3).addInvoice(new Invoice(750.,12));
        lsCustomer.get(4).addInvoice(new Invoice(1200.,8));
        lsCustomer.get(4).addInvoice(new Invoice(200.,6));


        System.out.println("/***********************************************/");
        //Tüm müşterileri listeleyin
        customerService.ListOfAllCustomer(lsCustomer);

        System.out.println("/***********************************************/");

        //Yeni Müşteri oluştur
        System.out.println("Do you want add new customer? press 1 for yes ");
        Scanner sc = new Scanner(System.in);
        int i=sc.nextInt();
        if (i==1){
            customerService.newCustomer(lsCustomer);}

        System.out.println("/***********************************************/");

        //İçerisinde ‘C’ harfi olan müşterileri listeleyin
        System.out.println("list of inculude c in name");
        customerService.CustomerWithLetterC(lsCustomer);

        System.out.println("/***********************************************/");

        //Haziran ayında kayıt olan müşterilerin faturalarınının toplam tutarını listeleyin
        customerService.registerDateJuneTotalAmount(lsCustomer);

        System.out.println("/***********************************************/");

        //Sistemdeki tüm faturaları listeleyin
        customerService.listOfAllInvoices(lsCustomer);

        System.out.println("/***********************************************/");

        //Sistemdeki 1500TL üstündeki faturaları listeleyin
        customerService.invoicesOver1500TL(lsCustomer);

        System.out.println("/***********************************************/");

        //Sistemdeki 1500TL üstündeki faturaları ortalamasını hesaplayın
        customerService.avarageOfInvoicesOver1500TL(lsCustomer);

        System.out.println("/***********************************************/");

        //Sistemdeki 500TL altındaki faturalara sahip müşterilerin isimleri listeleyin
        customerService.listOfCustomerNamesOfInvoicesUnder500TL(lsCustomer);

        System.out.println("/***********************************************/");

        //Haziran ayını faturalarını ortalaması 750 altı olan firmalarının hangi sektörde olduğunu listeleyen kodu yazın.
        customerService.listOfSector(lsCustomer);
    }

}
