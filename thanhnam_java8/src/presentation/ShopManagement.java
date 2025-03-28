package presentation;

import business.CustomerBusiness;
import business.OrderBusiness;
import entity.Customer;
import entity.Order;

import java.util.List;
import java.util.Scanner;

public class ShopManagement {
    public static List<Order> orderList;
    public static List<Customer> customerList;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OrderBusiness orderBusiness = new OrderBusiness();

        while (true) {
            System.out.println("***** SHOP MENU *****");
            System.out.println("1. Quản lý khách hàng");
            System.out.println("2. Quản lý đơn hàng");
            System.out.println("3. Thoát");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                CustomerBusiness.addCustomer(sc);
                CustomerBusiness.displayCustomers();
            } else if (choice == 2) {
                orderBusiness.addOrder(sc);
                orderBusiness.displayOrder();
            } else {
                break;
            }
        }
    }
}
