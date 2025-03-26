package bt3;

import java.util.Optional;

public class User {
    private String name;
    private Optional<String> phoneNumber;
    public User() {}
    public User(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = Optional.ofNullable(phoneNumber);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Optional<String> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Optional<String> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void printfInfor(){
        String phone = phoneNumber.orElse("không có");
        System.out.println("tên" +name +"sđt"+phone);
    }
}
