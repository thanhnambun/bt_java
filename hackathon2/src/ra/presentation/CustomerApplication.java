package ra.presentation;

import ra.bussiness.CustomerBusiness;
import ra.entity.Customer;

import java.util.Scanner;

public class CustomerApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Customer Menu");
            System.out.println("1. hiển thị ");
            System.out.println("2.thêm mới ");
            System.out.println("3. chỉnh sửa ");
            System.out.println("4. xóa");
            System.out.println("5.tìm kiếm ");
            System.out.println("6.sắp xếp ");
            System.out.println("0.thoát");
            System.out.println("vui lòng chọn ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    CustomerBusiness.displayCustomers();
                    break;
                case 2:
                    CustomerBusiness.addCustomer(sc);
                    break;
                case 3:
                    CustomerBusiness.updateCustomer(sc);
                    break;
                case 4:
                    CustomerBusiness.removeCustomer(sc);
                    break;
                case 5:
                    CustomerBusiness.searchCustomer(sc);
                    break;
                case 6:
                    CustomerBusiness.sortCustomer(sc);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("vui lòng nhập từ 0->6");
                    break;
            }
        } while (true);
    }
}
