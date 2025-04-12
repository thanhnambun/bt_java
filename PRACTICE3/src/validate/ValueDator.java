package validate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ValueDator {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static int validateInteger(Scanner sc, String message, int min) {
        System.out.println(message);
        while (true) {
            try {
                int number = Integer.parseInt(sc.nextLine());
                if (number > min) {
                    return number;
                }
                System.out.println("Dữ liệu phải lớn hơn " + min);
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập đúng định dạng số nguyên.");
            }
        }
    }

    public static double validateDouble(Scanner sc, String message) {
        while (true) {
            System.out.println(message);
            try {
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Không đúng định dạng kiểu double.");
            }
        }
    }

    public static String validateString(Scanner sc, StringRule stringRule, String message) {
        System.out.println(message);
        while (true) {
            String inputString = sc.nextLine().trim();
            if (stringRule.isValidString(inputString)) {
                return inputString;
            }
            System.err.println("Dữ liệu không hợp lệ, vui lòng nhập lại.");
        }
    }

    public static boolean validateBoolean(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim().toLowerCase();
            if (input.equals("true") || input.equals("yes")) return true;
            if (input.equals("false") || input.equals("no")) return false;
            System.out.println("Vui lòng nhập true/false hoặc yes/no.");
        }
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

    public static <T> String validateId(Scanner sc , String regex, List<T> nameList ){
        do {
            String inputString = validateString(sc, new StringRule(5,5), "vui lòng nhập id");
            if (Pattern.matches(regex, inputString)) {
                Optional<T> checkID = nameList.stream().filter(name->name.equals(inputString)).findFirst();
                if (checkID.isEmpty()) {
                    return inputString;
                }else {
                    System.err.println("id đã tồn ta vui lonòng nhập lại id");
                }
            }
            System.err.println("Dữ liệu không hợp lệ, vui lòng nhập lại");
        } while (true);
    }

}

