package persentation;

import business.CustomerBusiness;
import business.OrderBusiness;
import entity.Customer;
import entity.Orders;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShopManagement {
    public static final List<Customer> customersList = new ArrayList<Customer>();
    public static final List<Orders> ordersList = new ArrayList<>();

    private static void customerMenu(Scanner scanner) {
        while (true) {
            System.out.println("***********************CUSTOMER MENU******************");
            System.out.println("1. Danh sách khách hàng");
            System.out.println("2. Thêm mới khách hàng");
            System.out.println("3. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    CustomerBusiness.displayCustomers();
                    break;
                case 2:
                    CustomerBusiness.addCustomer(scanner);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng thử lại.");
            }
        }
    }
    private static void orderMenu(Scanner scanner,OrderBusiness orderBusiness) {
        while (true) {
            System.out.println("***********************ORDER MENU**********************");
            System.out.println("1. Danh sách đơn hàng");
            System.out.println("2. Thêm mới đơn hàng");
            System.out.println("3. Cập nhật trạng thái đơn hàng");
            System.out.println("4. Danh sách đơn hàng quá hạn");
            System.out.println("5. Thống kê số lượng đơn hàng đã giao");
            System.out.println("6. Tính tổng doanh thu các đơn hàng đã giao");
            System.out.println("7. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    orderBusiness.displayOrder();
                    break;
                case 2:
                    orderBusiness.addOrder(scanner);
                    break;
                case 3:
                    orderBusiness.updateOrderStatus(scanner);
                    break;
                case 4:
                    System.out.println("Danh sách đơn hàng quá hạn:");
                    orderBusiness.getOrderOverdue();
                    break;
                case 5:
                    long count = orderBusiness.getOrderOverdue().stream().filter(o -> o.isStatus()).count();
                    System.out.println("Số lượng đơn hàng đã giao: " + count);
                    break;
                case 6:
                    System.out.println("Tổng doanh thu: " + orderBusiness.getTotalRevenue() + " VNĐ");
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng thử lại.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderBusiness orderBusiness = new OrderBusiness();
        while (true) {
            System.out.println("**********************SHOP MENU*******************");
            System.out.println("1. Quản lý khách hàng");
            System.out.println("2. Quản lý đơn hàng");
            System.out.println("3. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    customerMenu(scanner);
                    break;
                case 2:
                    orderMenu(scanner,orderBusiness);
                    break;
                case 3:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng thử lại.");
            }
        }
    }
}
