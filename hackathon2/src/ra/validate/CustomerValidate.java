package ra.validate;

import ra.entity.Customer;

import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Pattern;

import static ra.bussiness.CustomerBusiness.customersList;

public class CustomerValidate {
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@gmail\\.com$";
    private static final String VIETNAM_PHONE_REGEX = "^(0|\\+84)[0-9]{7}$";

    public static String validateCustomerId(Scanner sc, String regex) {
        do {
            String inputString = Validator.validateString(sc, 255, "vui lòng nhập id");
            if (Pattern.matches(regex, inputString)) {

                return inputString;
            }
            System.err.println("Dữ liệu không hợp lệ, vui lòng nhập lại");
        } while (true);
    }

    public static String validateEmail(Scanner sc) {
        do {
            String email = Validator.validateString(sc, 200, "Vui lòng nhập email:");
            if (Pattern.matches(EMAIL_REGEX, email)) {
                return email;
            }
            System.err.println("Email không hợp lệ! Vui lòng nhập lại (chỉ chấp nhận Gmail).");
        } while (true);
    }


    public static String validatePhone(Scanner sc) {
        do {
            String phone = Validator.validateString(sc, 10, "vui lòng nhập số điện thoại");
            if (Pattern.matches(EMAIL_REGEX, phone)) {
                return phone;
            }
        } while (true);
    }

    public static String isExit(Scanner sc, String value, String type) {
        switch (type) {
            case "id":
                do {
                    String finalValue = value;
                    Optional<Customer> id = customersList.stream()
                            .filter(c -> c.getCustomerId().equalsIgnoreCase(finalValue))
                            .findFirst();
                    if (id.isPresent()) {
                        System.out.println("ID đã tồn tại, vui lòng nhập lại!");
                        value = Validator.validateString(sc, 255, "Vui lòng nhập ID mới:");
                    } else {
                        return value;
                    }
                } while (true);

            case "phone":
                do {
                    String finalValue1 = value;
                    Optional<Customer> phoneCheck = customersList.stream()
                            .filter(c -> c.getPhoneNumber().equalsIgnoreCase(finalValue1))
                            .findFirst();
                    if (phoneCheck.isPresent()) {
                        System.out.println("Số điện thoại đã tồn tại, vui lòng nhập lại!");
                        value = Validator.validateString(sc, 10, "Vui lòng nhập số điện thoại mới:");
                    } else {
                        return value;
                    }
                } while (true);

            case "email":
                do {
                    String finalValue2 = value;
                    Optional<Customer> emailCheck = customersList.stream()
                            .filter(c -> c.getEmail().equalsIgnoreCase(finalValue2))
                            .findFirst();
                    if (emailCheck.isPresent()) {
                        System.out.println("Email đã tồn tại, vui lòng nhập lại!");
                        value = Validator.validateString(sc, 200, "Vui lòng nhập email mới:");
                    } else {
                        return value;
                    }
                } while (true);

            default:
                System.err.println("Loại kiểm tra không hợp lệ.");
                return null;
        }
    }
}
