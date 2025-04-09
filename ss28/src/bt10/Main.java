package bt10;

import bt10.presentation.AccountUI;
import bt10.presentation.FunstranferUI;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1.quản lý tài khoản");
            System.out.println("2. quản lý giao dịch");
            System.out.println("vui lòng chọn ");
            choice = sc.nextInt();
            if (choice == 1) {
                AccountUI.displayAccountMenu(sc);
            }else if (choice == 2) {
                FunstranferUI.displayFundsTransferMenu(sc);
            }else {
                System.out.println("vui lon chọn 1 hoặc 2");
            }
        }while (true);
    }
}