package bt10.business.model;

import java.util.Scanner;

public class Account {
    private int accId;
    private String accName;
    private double balance;
    private AccountStatus status;

    public Account() {
    }

    public Account(int accId, AccountStatus status, String accName, double balance) {
        this.accId = accId;
        this.status = status;
        this.accName = accName;
        this.balance = balance;
    }

    public int getAccId() {
        return accId;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }
    public void inputData(Scanner sc){
        System.out.println("nhập id ");
        this.accId = Integer.parseInt(sc.nextLine());
        System.out.println("nhập tên ");
        this.accName = sc.nextLine();
        this.balance = 0.0;
        this.status = AccountStatus.ACTIVE;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accId=" + accId +
                ", accName='" + accName + '\'' +
                ", balance=" + balance +
                ", status=" + status +
                '}';
    }
}
