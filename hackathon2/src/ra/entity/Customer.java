package ra.entity;

import ra.validate.CustomerValidate;
import ra.validate.Validator;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Customer implements IApp {
    private String customerId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private boolean gender;
    private String address;
    private String phoneNumber;
    private String email;
    private String customerType;

    public Customer() {}

    public Customer(String customerId, String firstName, String lastName, LocalDate dateOfBirth, boolean gender, String address, String phoneNumber, String email, String customerType) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.customerType = customerType;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    @Override
    public void inputData(Scanner sc) {
        this.customerId = inputId(sc);
        this.firstName = Validator.validateString(sc,50,"vui lòng nhập tên");
        this.lastName =Validator.validateString(sc,0,"vui lòng nhập họ");
        this.dateOfBirth=Validator.validateDate("vui lòng nhập ngày sinh ",sc);
        this.gender=Validator.validateBoolean(sc,"vui lòng nhập giới tính");
        this.address = Validator.validateString(sc,255,"vuii lòng nhập địa chỉ");
        this.phoneNumber=inputPhone(sc);
        this.email=inputEmail(sc);
        this.customerType=Validator.validateString(sc,255,"vui lòng nhập loại khách hàng");
    }

    @Override
    public void displayData(Scanner sc) {
        System.out.printf("id :%s ,tên :%s ,họ:%s,ngày sinh:%s\n",customerId,firstName,lastName,dateOfBirth);
        System.out.printf("gender :%s, địa chỉ :%s,Loại khách hàng :%s\n",gender,address,customerType);
        System.out.println("số điện thoại "+phoneNumber+ "email"+email);
    }
    public  String inputId(Scanner sc) {
        String inputId = CustomerValidate.validateCustomerId(sc,"{C}w\\4");
        return CustomerValidate.isExit(sc,inputId,"id");
    }
    public static String inputPhone(Scanner sc) {
        String phone = CustomerValidate.validatePhone(sc);
        return CustomerValidate.isExit(sc,phone,"phone");
    }
    public static String inputEmail(Scanner sc) {
        String email = CustomerValidate.validateEmail(sc);
        return CustomerValidate.isExit(sc,email,"email");
    }
}
