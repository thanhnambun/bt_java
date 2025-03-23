import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

class Contact {
    private static int AUTO_ID = 1;

    private int id;
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.id = AUTO_ID++;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return phoneNumber.equals(contact.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "ID=" + id +
                ", Name='" + name + '\'' +
                ", PhoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}

public class ContactManager {
    private static Set<Contact> contacts = new HashSet<>();

    public static void addContact(Scanner sc) {
        System.out.println("vui lòng nhập tên liên lạc ");
        String nameContact = sc.nextLine();
        System.out.print("Nhập số điện thoại: ");
        String phoneNumber = sc.nextLine();
        Contact newContact = new Contact(nameContact, phoneNumber);
        if (contacts.contains(newContact)) {
            System.out.println("số điện thoại hoặc tên đã có trong danh bạ");
        } else {
            contacts.add(newContact);
            System.out.println("đã thêm thành công ");
        }
    }

    public static void removeContact(Scanner sc) {
        System.out.println("vui lòng nhập phoneNumber ");
        String phoneNumberCheck = sc.nextLine();
        Contact found = null;
        for (Contact contact : contacts) {
            if (contact.getPhoneNumber().equals(phoneNumberCheck)) {
                found = contact;
                break;
            }
        }
        if (found != null) {
            System.out.println("đã xóa ");
            contacts.remove(found);
        } else {
            System.out.println("o tìm thấy");
        }
    }

    public static void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Danh bạ trống.");
        } else {
            System.out.println("Danh sách liên hệ:");
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Thêm liên hệ");
            System.out.println("2. Xóa liên hệ");
            System.out.println("3. Hiển thị danh bạ");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    addContact(sc);
                    break;
                case 2:
                    removeContact(sc);
                    break;
                case 3:
                    displayContacts();
                    break;
                case 0:
                    System.out.println("Đã thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }

        } while (choice != 0);
    }
}
