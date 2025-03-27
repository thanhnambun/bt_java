package business;


import entity.Order;

import java.util.List;
import java.util.Scanner;

public interface IOrderBusiness {
    void addOrder(Scanner sc);

    void displayOrder();

    void updateOrderStatus(Scanner sc);
    List<Order> getOrderOverdue();
    List<Order> getOrderDelivied();
    default double getTotalRevenue(){
        return  getOrderDelivied().stream().mapToDouble(Order::getTotalAmount).sum();
    }

}
