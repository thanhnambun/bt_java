package ra.bussiness;

import ra.entity.Customer;
import ra.validate.Validator;

import java.util.*;

public class CustomerBusiness {
    public static final List<Customer> customersList = new ArrayList<>();

    public static void displayCustomers() {
        customersList.forEach(System.out::println);
    }

    public static void addCustomer(Scanner sc) {
        System.out.println("vui lòng nhập số lượng khách hàng cần thêm");
        try {
            int n = Integer.parseInt(sc.nextLine());
            for (int i = 1; i <= n; i++) {
                Customer customer = new Customer();
                customer.inputData(sc);
                customersList.add(customer);
                System.out.println("đã thêm thành công người dùng ");
            }
        } catch (Exception e) {
            System.out.println("lỗi dữ liệu ");
        }
    }

    public static Optional<Customer> findCustomer(String id) {
        return customersList.stream()
                .filter(c -> c.getCustomerId().equalsIgnoreCase(id))
                .findFirst();
    }

    public static void updateCustomer(Scanner sc) {
        System.out.println("vui lòng nhập mã người dùng cần sửa ");
        String id = sc.nextLine();
        int choice;
        if (findCustomer(id).isPresent()) {
            Customer customer = findCustomer(id).get();
            do {
                System.out.println("1. sửa tên");
                System.out.println("2.sửa họ");
                System.out.println("3. sửa ngày sinh");
                System.out.println("4.sửa giới tính");
                System.out.println("5. sửa địa chỉ");
                System.out.println("6. sửa số điện thoại");
                System.out.println("7. sửa email");
                System.out.println("8. sửa loại khách hàng ");
                System.out.println("9. thoát ");
                System.out.println("vui lòng chọn");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        String firstName = Validator.validateString(sc, 50, "vui lòng nhập tên ");
                        customer.setFirstName(firstName);
                        break;
                    case 2:
                        String lastName = Validator.validateString(sc, 50, "vui lòng nhập họ ");
                        customer.setLastName(lastName);
                        break;
                    case 3:
                        customer.setDateOfBirth(Validator.validateDate("vui lòng nhâ ngày sinh", sc));
                        break;
                    case 4:
                        customer.setGender(Validator.validateBoolean(sc, "vui lòng nhập giới tính"));
                        break;
                    case 5:
                        customer.setAddress(Validator.validateString(sc, 255, "vui lòng nhập địa chỉ "));
                        break;
                    case 6:
                        Customer.inputPhone(sc);
                        break;
                    case 7:
                        Customer.inputEmail(sc);
                        break;
                    case 8:
                        customer.setCustomerType(Validator.validateString(sc, 255, "vui lòng nhập loaij khách hàng "));
                        break;
                    case 9:
                        System.out.println("đã chỉnh sửa thông tin thành công");
                        System.exit(0);
                        break;
                }
            } while (true);
        }
    }

    public static void removeCustomer(Scanner sc) {
        System.out.println("vui lòng nhập id khách hàng cần xóa ");
        String id = sc.nextLine();
        int choice;
        if (findCustomer(id).isPresent()) {
            Customer customer = findCustomer(id).get();
            System.out.println(customer);
            System.out.println("bạn có đồng ý xóa không ");
            System.out.println("1.yes");
            System.out.println("2. no");
            choice = sc.nextInt();
            if (choice == 1) {
                customersList.remove(customer);
            } else if (choice == 2) {
                System.out.println(" đã hủy bỏ thao tác ");
            } else {
                System.out.println("chọn 1 và 2 ");
            }
        }
    }

    public static void searchCustomer(Scanner sc) {
        int choice;
        do {
            System.out.println("1. tìm kiếm theo tên");
            System.out.println("2.tìm kiếm theo loại");
            System.out.println("3. tìm kiếm theo số điện thoại ");
            System.out.println("4.thoát");
            System.out.println("vui lòng chọn ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("vui lòng nhập tên cần tìm kiếm");
                    customersList.stream().filter(c -> c.getFirstName().equals(sc.nextLine())).forEach(System.out::println);
                    break;
                case 2:
                    System.out.println("vui lòng nhập lạo khách hàng cần tìm keiesm ");
                    customersList.stream().filter(c -> c.getCustomerType().equals(sc.nextLine())).forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("vui lòng nhập số ddienj thoại cần timf keiems ");
                    customersList.stream().filter(c -> c.getPhoneNumber().equals(sc.nextLine())).forEach(System.out::println);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("vui lòng chọn từ 1 - 4");
                    break;
            }
        } while (true);
    }

    public static void sortCustomer(Scanner sc) {
        int choice;
        do {
            System.out.println("1 sắp xếp theo tên tăng dần/ giảm dần  ");
            System.out.println("2. sắp xếp theo ngày sinh tăng dần / giảm dần  ");
            System.out.println("3.thoát");
            System.out.println("chọn");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("sắp xếp theo tên tăng dần ");
                    customersList.sort(Comparator.comparing(Customer::getFirstName));
                    break;
                case 2:
                    customersList.sort(Comparator.comparing(Customer::getDateOfBirth));
                    break;
                case 3:
                    break;
                default:
                    System.out.println("vui lòng nhập từ 1-3");
                    break;
            }
        } while (true);
    }
}
