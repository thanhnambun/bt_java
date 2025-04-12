package presentation;

import business.model.Account;
import validate.Validator;

import java.util.Scanner;

public class LoginUI {
    public static Account checkAcc;
    public static void displayMenu(Scanner sc) {
        int choice;
        do {
            System.out.println("1. Quản lý phòng ban ");
            System.out.println("2. Quản lý nhân viên");
            System.out.println("3. Thống kê");
            System.out.println("4. Đăng xuất ");
            System.out.printf("vui lòng chọn");
            choice = Validator.validateChoice(sc);
            switch (choice) {
                case 1:
                    DepartmentUI.displayMenuDepartment(sc);
                    break;
                case 2:
                    EmployessUI.displayMenu(sc);
                    break;
                case 3:
                    StatisticalUI.displayMenu(sc);
                    break;
                case 4:
                    checkAcc = null;
                    return;
                default:
                    System.out.println("vui lòng chọn từ 1-3");
                    break;
            }
        } while (true);
    }
}
