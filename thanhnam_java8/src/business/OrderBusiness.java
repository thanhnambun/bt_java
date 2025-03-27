package business;

import entity.Customer;
import entity.Order;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static presentation.ShopManagement.orderList;

public class OrderBusiness implements IOrderBusiness {

    @Override
    public void addOrder(Scanner sc) {
        Order order=new Order();
        order.inputData(sc);
        orderList.add(order);
        System.out.println("đã theemthanfh công đơn hàng");
    }

    @Override
    public void displayOrder() {
        do {
            System.out.println("1.danh sách đơn hàng");
            System.out.println("2.thêm mơí đơn hàng");
            System.out.println("3.cập nahat");
            System.out.println("4. danh sách quá hạn");
            System.out.println("5.danh sach đã giao");
            System.out.println("6.");
        }while (true);
    }

    @Override
    public void updateOrderStatus(Scanner sc) {
        System.out.println("vui lòng nhập id của đơn hàng cần chỉnh sửa ");
        int orderid=sc.nextInt();
        for(Order order:orderList){
            if(orderid==order.getId()){
                System.out.println(order);
                Customer customeruNew = new Customer();
                System.out.println("vui lòng nhập tên ");
                customeruNew.setName(sc.next());
                System.out.println("vui lòng nhập email");
                customeruNew.setEmail(Optional.of(sc.nextLine()));
                order.setCustomer(customeruNew);
                System.out.println("vui lòng suawar ngày đặt hàng ");
                order.setOrderDate(LocalDate.of(sc.nextInt(),sc.nextInt(),sc.nextInt()));
                System.out.println("vui lòng sửa tổng tiền ");
                order.setTotalAmount(sc.nextDouble());
                System.out.println("vui lòng sửa trạng thái");
                order.setStatus(sc.nextBoolean());
            }
        }
    }

    @Override
    public List<Order> getOrderOverdue() {
        return orderList.stream().
                filter(o->o.isStatus() && o.getOrderDate().isAfter(LocalDate.now())).toList();
    }

    @Override
    public List<Order> getOrderDelivied() {
        return orderList.stream()
                .filter(o->!o.isStatus()).toList();
    }
}
