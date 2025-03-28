package entity;

import java.time.LocalDate;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

import static persentation.ShopManagement.customersList;

public class Orders implements IApp {
    private  int orderIdSequen;
    private int id;
    private Customer customer;
    private LocalDate orderDate;
    private double totalAmount;
    private boolean status;

    public Orders() {
        this.id = ++orderIdSequen;
    }

    public Orders(int id, Customer customer, LocalDate orderDate, double totalAmount, boolean status) {
        this.id = ++orderIdSequen;
        this.customer = customer;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public int getId() {
        return id;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner sc) {
        this.customer = choiceCustomer(sc);
        this.orderDate= LocalDate.of(sc.nextInt(),sc.nextInt(),sc.nextInt());
        System.out.println("vui lòng nhập tổng tiền hàng");
        this.totalAmount = sc.nextDouble();
        this.status= false;
    }

    private Customer choiceCustomer(Scanner sc){
        System.out.println("chọn khách hàng ");
        do {
            if (customersList.isEmpty()){
                return null;
            }
            customersList.stream().
                    forEach(c -> System.out.println("id :"+c.getId() +" name :"+c.getName()));
            System.out.println("lawuj chọn của bạn ");
            Integer choice = sc.nextInt();
            OptionalInt indexCustomer = IntStream.range(0, customersList.size())
                    .filter(index -> customersList.get(index).getId() == choice).findFirst();
            if (indexCustomer.isPresent()) {
                return customersList.get(choice);
            }
            System.err.println("lựa chọn không đúng vui lòng nhập lại ");
        }while (true);
    }

    @Override
    public String toString() {
        return "Mã đơn hàng: " + this.id + ", Khách hàng: " + (this.customer == null ? "Không có khách hàng" : this.customer.getName())
                + ", Ngày đặt hàng: " + this.orderDate + ", Tổng tiền: " + this.totalAmount + ", Trạng thái: " + (this.status ? "Đã giao hàng" : "Chưa giao hàng");
    }
}
