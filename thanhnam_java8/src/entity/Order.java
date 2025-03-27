package entity;

import java.time.LocalDate;
import java.util.Scanner;

public class Order implements IApp {
    private  int orderidCount;
    private int id;
    private Customer customer;
    private LocalDate orderDate;
    private double totalAmount;
    private boolean status;

    public Order() {}

    public Order(int id, Customer customer, LocalDate orderDate, double totalAmount, boolean status) {
        this.id = id;
        this.customer = customer;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        this.id = orderidCount++;
        getCustomer().inputData(sc);
        this.orderDate= LocalDate.of(sc.nextInt(),sc.nextInt(),sc.nextInt());
        System.out.println("vui lòng nhập tổng tiền hàng");
        this.totalAmount = sc.nextDouble();
        this.status= false;
    }
    @Override
    public String toString() {
        return "Order{" +"id :" +this.id+ " customer"+this.customer+" ngày đặt"+this.orderDate+" tổng tiền hàng " + this.totalAmount +" trạng thái "+this.status+"}";
    }
}
