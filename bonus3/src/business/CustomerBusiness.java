package business;

import entity.Customer;

import java.time.LocalDate;
import java.util.Scanner;

import static persentation.ShopManagement.customersList;
import static persentation.ShopManagement.ordersList;

public class CustomerBusiness {
    public static void addCustomer(Scanner sc) {
        Customer customer = new Customer();
        customer.inputData(sc);
        customersList.add(customer);
    }

    public static void displayCustomers() {
        customersList.forEach(c -> {
            System.out.println(c);
                long totalOrders = ordersList.stream().filter(u->u.getCustomer().equals(c)).count();
                long totalOrdersOverdue = ordersList.stream().filter(u->u.getCustomer().equals(c) && !u.isStatus()&&u.getOrderDate().isBefore(LocalDate.now())).count();
            System.out.printf("Tổng số đơn hàng: %d - Tổng số đơn hàng quá hạn: %d\n", totalOrders, totalOrdersOverdue);
                }
        );
    }

}
