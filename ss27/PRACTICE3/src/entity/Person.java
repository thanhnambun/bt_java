package entity;

import validate.PersonValidate;
import validate.StringRule;
import validate.ValueDator;

import java.util.Scanner;

public class Person implements IApp {
    private String personName;
    private int personAge;
    private String personAddress;
    private String personPhone;
    private String personEmail;
    private Sex gender;

    public enum Sex {
        MALE, FEMALE, OTHER;
    }

    public Person() {
    }

    public Person(String personName, int personAge, String personAddress, String personPhone, String personEmail, Sex gender) {
        this.personName = personName;
        this.personAge = personAge;
        this.personAddress = personAddress;
        this.personPhone = personPhone;
        this.personEmail = personEmail;
        this.gender = gender;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int getPersonAge() {
        return personAge;
    }

    public void setPersonAge(int personAge) {
        this.personAge = personAge;
    }

    public String getPersonAddress() {
        return personAddress;
    }

    public void setPersonAddress(String personAddress) {
        this.personAddress = personAddress;
    }

    public String getPersonPhone() {
        return personPhone;
    }

    public void setPersonPhone(String personPhone) {
        this.personPhone = personPhone;
    }

    public String getPersonEmail() {
        return personEmail;
    }

    public void setPersonEmail(String personEmail) {
        this.personEmail = personEmail;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    @Override
    public void inputData(Scanner sc) {
        this.personName = ValueDator.validateString(sc, new StringRule(150, 0), "Vui lòng nhập tên người:");
        this.personAge = ValueDator.validateInteger(sc, "Vui lòng nhập tuổi:", 18);
        this.personAddress = ValueDator.validateString(sc, new StringRule(255, 0), "Vui lòng nhập địa chỉ:");
        this.personEmail = PersonValidate.validateEmail(sc);
        this.personPhone = PersonValidate.validatePhone(sc);

        System.out.println("Chọn giới tính (1. MALE, 2. FEMALE, 3. OTHER):");
        int choice;
        do {
            choice = sc.nextInt();
            sc.nextLine(); // Đọc dòng mới tránh lỗi
            switch (choice) {
                case 1:
                    this.gender = Sex.MALE;
                    break;
                case 2:
                    this.gender = Sex.FEMALE;
                    break;
                case 3:
                    this.gender = Sex.OTHER;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại.");
            }
        } while (choice < 1 || choice > 3);
    }

    @Override
    public String toString() {
        return "Person{" +
                "personName='" + personName + '\'' +
                ", personAge=" + personAge +
                ", personAddress='" + personAddress + '\'' +
                ", personPhone='" + personPhone + '\'' +
                ", personEmail='" + personEmail + '\'' +
                ", gender=" + gender +
                '}';
    }
}
