package business;

import entity.Customer;
import entity.Orders;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

import static persentation.ShopManagement.customersList;
import static persentation.ShopManagement.ordersList;

public class OrderBusiness implements IOdersBusiness {

    @Override
    public void addOrder(Scanner sc) {
        System.out.println("Nhập vào số đơn hàng cần nhập thông tin:");
        int sizeOrder = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < sizeOrder; i++) {
            Orders order = new Orders();
            order.inputData(sc);
            ordersList.add(order);
        }
    }

    @Override
    public void displayOrder() {
        ordersList.forEach(System.out::println);
    }

    @Override
    public void updateOrderStatus(Scanner sc) {
        System.out.println("vui lòng nhập id cần cập nhật");
        int id = Integer.parseInt(sc.nextLine());
        OptionalInt optIndex = IntStream.range(0, ordersList.size()).filter(i -> ordersList.get(i).getId() == id).findFirst();
        if (optIndex.isPresent()) {
            System.out.println("vui lòng nhạp trạng thái ");
            ordersList.get(optIndex.getAsInt()).setStatus(Boolean.parseBoolean(sc.nextLine()));
        }
    }

    @Override
    public List<Orders> getOrderOverdue() {
        return ordersList.stream()
                .filter(order -> !order.isStatus() && order.getOrderDate().isBefore(LocalDate.now()))
                .toList();
    }

    @Override
    public List<Orders> getOrderDelivied() {
        return ordersList.stream().filter(Orders::isStatus).toList();
    }
}
