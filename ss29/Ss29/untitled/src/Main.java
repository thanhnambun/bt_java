import business.model.Account;
import business.service.login.LoginServiceImp;
import presentation.LoginUI;

import java.util.Scanner;

import static presentation.LoginUI.checkAcc;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("----------Đăng nhập ------------");
        Account account = new Account();
        account.inputData(sc);
        LoginServiceImp loginService = new LoginServiceImp();
        checkAcc = loginService.login(account.getUsername(),  account.getPassword());
        if(checkAcc!=null ){
            LoginUI.displayMenu(sc);
        }else{
            System.err.println("Không có thông tin tài khoản bạn vừa nhập ");
        }
    }
}