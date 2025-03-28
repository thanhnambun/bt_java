package business;


import entity.Orders;

import java.util.List;
import java.util.Scanner;

public interface IOdersBusiness {
    void addOrder(Scanner sc);

    void displayOrder();

    void updateOrderStatus(Scanner sc);
    List<Orders> getOrderOverdue();
    List<Orders> getOrderDelivied();
    default double getTotalRevenue(){
        return  getOrderDelivied().stream().mapToDouble(Orders::getTotalAmount).sum();
    }

}
