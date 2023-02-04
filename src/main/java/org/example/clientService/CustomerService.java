package org.example.clientService;

import org.example.clientInt.CustomerInt;
import org.example.mainApp.Main;
import org.example.model.Customer;
import org.example.model.Invoice;

import java.util.*;
import java.util.stream.Collectors;

public class CustomerService implements CustomerInt {


    protected List<Customer> customers= new ArrayList<>();

    @Override
    public void ListOfAllCustomer(List<Customer> ls) {

        List<Customer> ls2= (ls.stream().collect(Collectors.toList()));
        System.out.println("List Of All Customer: "+ls2);

    }

    //Yeni müşteri ekle

    @Override
    public void newCustomer(List<Customer> ls) {
        Scanner sc = new Scanner(System.in);
        System.out.println("please press 1 If you want add new customer ");

        List<String > lst= new ArrayList<>();
        for (Customer item:ls
             ) {
          lst.add( item.getName()) ;
        }
        int nameNumber=lst.size();

            System.out.println("Please enter Name?");
            String name= sc.nextLine();
            System.out.println("Surname");
            String surname= sc.nextLine();
            System.out.println("sector");
            String sector= sc.nextLine();
            System.out.println("amount Of invoice");
            Double amount=sc.nextDouble();
            System.out.println("registerDate(Just Mounth)");
            int registerDate= sc.nextInt();
            System.out.println("invoiceDate(Just Mounth)");
            int invoiceDate= sc.nextInt();
            ls.add(new Customer(name,surname,registerDate,sector));
            ls.get(nameNumber).addInvoice(new Invoice(amount,invoiceDate));

            List<Customer> ls2= (ls.stream().collect(Collectors.toList()));
            System.out.println("New Customer List Of All Customer: "+ ls2);
        }


//İçerisinde ‘C’ harfi olan müşterileri listeleyin

    @Override
    public void CustomerWithLetterC(List<Customer> ls) {


        ls.stream()
                .filter(customer -> customer.getName().toLowerCase().contains("c") || customer.getSurName().toLowerCase().contains("c"))
                .forEach(cCustomer -> System.out.println("List of customers with the letter 'C' in it: "+ cCustomer.getName() + " " + cCustomer.getSurName()));


/*        List<Customer> ls2=new ArrayList<>();

        System.out.println("Customer With Letter C");

        for (Customer item:ls
             ) {
            if (item.getName().contains("c")){
                ls2.add(item);
            }else if (item.getSurName().contains("c")){
                ls2.add(item);
            };

            System.out.println(ls2);
        }*/}

    //Haziran ayında kayıt olan müşterilerin faturalarınının toplam tutarını listeleyin

    @Override
    public void registerDateJuneTotalAmount(List<Customer> ls) {



        double totalInvoiceAmount = ls.stream()
                .filter(customer -> customer.getRegisterDate() == 6)
                .flatMap(customer -> customer.getInvoices().stream())
                .mapToDouble(Invoice::getAmount)
                .sum();
        System.out.println("Total invoice amount for June registered customers: " + totalInvoiceAmount);


        /*        Double sum = ls.stream()
                .filter(c -> c.getRegisterDate() == 6)
                .mapToDouble(c -> c.getInvoices().stream().mapToDouble(Invoice::getAmount).sum())
                .sum();
        System.out.println("Total invoice amount for June registered customers: " + sum);*/

/*        double totalInvoiceAmount = 0.0;
        for (Customer customer : ls) {
            if (customer.getRegisterDate() == 6) {
                for (Invoice invoice : customer.getInvoices()) {
                    totalInvoiceAmount += invoice.getAmount();
                }
            }
        }
        System.out.println("Total invoice amount for June registered customers: " + totalInvoiceAmount);*/

/*        double total = ls.stream()
                .filter(c -> c.getRegisterDate() == 6)
                .flatMap(c -> c.getInvoices().stream()
                        )
                .mapToDouble(Invoice::getAmount)
                .sum();

        System.out.println(total);*/


/*        List<Invoice> lst= new ArrayList<>();

        double total = 0.0;

        if (ls.stream().filter(number -> Boolean.parseBoolean(String.valueOf(number))).equals("6")){


            for (Invoice item:lst
                 ) {
                total = + item.getAmount();
            }

        }
        System.out.println(total);*/



//        double total = ls.stream()
//                .reduce(0.0, (acc, invoice) -> {
//                    if (invoice.getDate().getMonthValue() == 5) {
//                        acc += invoice.getAmount();
//                    }
//                    return acc;
//                });

/*        Double total= ls.stream()
                .filter(number -> String.valueOf(number).equals("6"))
                .mapToDouble(Customer::getInvoices.)
                .sum();*/



        }



        /*        ls.stream()
                .filter(registerDate -> String.valueOf(registerDate).equals("7"))
                .forEach(registerDate -> System.out.println(registerDate));*/


/*        List<Customer> lst= Arrays.stream(ls)
                .


                lst = ls.stream()
                        .filter(ls.getClass() -> number == 7)
                        .boxed()
                        .collect(Collectors.toList());

                System.out.println(sevens);*/


//List Of All Invoices

    @Override
    public void listOfAllInvoices(List<Customer> ls) {

        for (Customer customer : ls) {
            System.out.println("Customer Name: " + customer.getName() + " " + customer.getSurName());
            System.out.println("Job: " + customer.getSector());
            System.out.println("Invoices:");
            for (Invoice invoice : customer.getInvoices()) {
                System.out.println("amounts: " + invoice.getAmount() );
            }

        }

    }
    //Sistemdeki 1500TL üstündeki faturaları listele
    @Override
    public void invoicesOver1500TL(List<Customer> ls) {
        List<Invoice> invoices = new ArrayList<>();
        for (Customer customer : ls) {
            invoices.addAll(customer.getInvoices());
        }

        List<Invoice> result = invoices.stream()
                .filter(invoice -> invoice.getAmount() > 1500)
                .collect(Collectors.toList());

        System.out.println("Invoices with amount greater than 1500: " + result);

    }


    //Sistemdeki 1500TL üstündeki faturaları ortalamasını hesaplayın

    @Override
    public void avarageOfInvoicesOver1500TL(List<Customer> ls) {

        double sum = 0.0;
        int count = 0;
        for (Customer c : ls) {
            for (Invoice i : c.getInvoices()) {
                if (i.getAmount() > 1500.0) {
                    sum += i.getAmount();
                    count++;
                }
            }
        }
        double average = sum / count;
        System.out.println("Average of invoices over 1500TL: " + average);




    }

    ////Sistemdeki 500TL altındaki faturalara sahip müşterilerin isimleri listeleyin

    @Override
    public void listOfCustomerNamesOfInvoicesUnder500TL(List<Customer> ls) {




        List<String> names= ls.stream()
                .filter(item ->item.getInvoices().stream()
                        .anyMatch(invoice -> invoice.getAmount()<500))
                .map(Customer::getName)
                .collect(Collectors.toList());

        System.out.println("Customers with invoices under 500TL: "+ names);



/*        List<Invoice> invoiceList= new ArrayList<>();

        for (Customer item:ls
             ) {
            invoiceList.addAll(item.getInvoices());
        }

        List<Invoice> lsResult=invoiceList.stream()
                .filter(invoice -> invoice.getAmount()<500 )
                .collect(Collectors.toList());*/






/*        List<String> names = ls.stream()
                .filter(c -> c.getInvoices().stream()
                        .anyMatch(i -> i.getAmount() < 500.0))
                .map(Customer::getName)
                .collect(Collectors.toList());

        System.out.println("Customers with invoices under 500TL: " + names);*/


    }

    //Haziran ayını faturalarını ortalaması 750 altı olan firmalarının hangi sektörde olduğunu listeleyen kodu yazın.
    @Override
    public void listOfSector(List<Customer> ls) {

        List<String> sectorLisr=ls.stream()
                .filter(customer -> customer.getInvoices().stream()
                        .anyMatch(invoice -> invoice.getInvoiceDate()==6 && invoice.getAmount()<750))
                .map(Customer :: getSector )
                .collect(Collectors.toList());

        System.out.println("List in which sector the companies with an average invoice of less than 750 for the month of June are in: "+ sectorLisr );
    }
}