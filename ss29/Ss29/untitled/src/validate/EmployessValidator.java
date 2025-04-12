package validate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Pattern;

import static validate.Validator.validateString;

public class EmployessValidator {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static <T> String validateId(Scanner sc , String regex ){
        do {
            String inputString = validateString(sc, "vui lòng nhập id", new StringRule(5,5));
            if (Pattern.matches(regex, inputString)) {
                    return inputString;
            }
            System.err.println("Dữ liệu không hợp lệ, vui lòng nhập lại");
        } while (true);
    }
    public static LocalDate validateDate(String message, Scanner scanner) {
        System.out.println(message);
        while (true) {
            try {
                return LocalDate.parse(scanner.nextLine(), DATE_FORMATTER);
            } catch (DateTimeParseException e) {
                System.err.println("Định dạng ngày tháng không đúng (dd/MM/yyyy), vui lòng nhập lại.");
            }
        }
    }
    public static String validateEmail(Scanner scanner, String message) {
        System.out.println(message);
        while (true) {
            String value = scanner.nextLine().trim();
            if (value.isEmpty()) {
                System.err.println("Bạn chưa nhập email sinh viên, vui lòng nhập lại");
                continue;
            }
            if (Validator.isValidEmail(value)) {
                return value;
            }
            System.err.println("Không đúng định dạng email, vui lòng nhập lại");

        }
    }

    public static String validatePhone(Scanner scanner, String message) {
        System.out.println(message);
        while (true) {
            String value = scanner.nextLine().trim();
            if (value.isEmpty()) {
                System.err.println("Bạn chưa nhập số điện thoại của sinh viên, vui lòng nhập lại");
                continue;
            }
            if (Validator.isValidPhoneNumberVN(value)) {
                return value;
            }
            System.err.println("Không đúng số điện thoại di đông VN, vui lòng nhập lại");
        }
    }

}
