package entity;

import java.util.Optional;
import java.util.Scanner;

public class Customer implements IApp {
    private int countSequen =0;
    private int id ;
    private String name;
    private Optional<String> email;

    public Customer() {
        this.id = ++countSequen;
    }

    public Customer( int id, String name, String email) {
        this.id = ++countSequen;
        this.name = name;
        this.email = Optional.ofNullable(email);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Optional<String> getEmail() {
        return email;
    }

    public void setEmail(Optional<String> email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name + ", email=" + email + '}';
    }

    @Override
    public void inputData(Scanner sc) {
        this.id=countSequen++;
        System.out.println("vui lòng nhâ tên ");
        this.name=sc.nextLine();
        System.out.println("vui lòng nhập email");
        String emailInput=sc.nextLine();
        this.email = emailInput.isEmpty() ? Optional.empty() : Optional.of(emailInput);
    }
}
