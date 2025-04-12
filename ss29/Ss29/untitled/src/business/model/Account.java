package business.model;

import java.util.Scanner;

public class Account {
    private int idSequance =0;
    private int id;
    private String username;
    private String password;
    private Status status_account;

    public Account() {
        this.id = ++ idSequance;
    }

    public Account( String username, String password, Status status_account) {
        this.id = ++ idSequance;
        this.username = username;
        this.password = password;
        this.status_account = status_account;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Status getStatus_account() {
        return status_account;
    }

    public void setStatus_account(Status status_account) {
        this.status_account = status_account;
    }

    public void inputData(Scanner sc){
        System.out.println("vui lòng nhập tên đăng nhập ");
        this.username =  sc.nextLine();
        System.out.println("vui lòng nhập password ");
        this.password =  sc.nextLine();
    }
    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", status_account=" + status_account +
                '}';
    }
}
