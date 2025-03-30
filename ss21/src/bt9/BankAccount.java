package bt9;

import java.util.Scanner;

public class BankAccount {
    private String accountId;
    private double balance;
    public BankAccount(){}
    public BankAccount(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void deposit(Scanner sc){
        System.out.println("nhập số tiền cần gửi ");
        try{
            Double amount = Double.parseDouble(sc.nextLine());
            balance += amount;
        }catch(Exception e){
            System.out.println("số tiền ửi không hợp lệ");
        }
    }
    public void withdraw(Scanner sc){
        System.out.println("nập số tieenf cần rút");
        try{
            Double amount = Double.parseDouble(sc.nextLine());
            if (amount < balance){
                balance -= amount;
            }
            System.out.println("số tiền rút lớn hơn số dư tài khaorn ");
        }catch(Exception e){
            System.out.println("số tiền cần rutsk hoogn hợp lệ");
        }
    }
    public void Transfer(Scanner sc, BankAccount b2){
        System.out.println("vui lòng nhập số tiền cần chueyern ");
        try{
            Double amount = Double.parseDouble(sc.nextLine());
            if (amount < balance){
                balance -= amount;
                b2.setBalance(b2.balance + amount);
                System.out.println("chuyển khoản thành công ");
            }
            System.out.println("số dư không đủ để chuyển khoarn");
        }catch (Exception e){

        }
    }
}
