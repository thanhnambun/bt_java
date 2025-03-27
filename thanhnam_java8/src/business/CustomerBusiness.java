package business;

import entity.Customer;

import java.util.Scanner;

import static presentation.ShopManagement.customerList;

public class CustomerBusiness {
    public static void addCustomer(Scanner sc){
        Customer customer = new Customer();
        customer.inputData(sc);
        customerList.add(customer);
    }
    public static void displayCustomers(){
        customerList.forEach(System.out::println);
    }

}
