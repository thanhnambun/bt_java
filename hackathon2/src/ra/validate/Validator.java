package ra.validate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Validator {
    public static String validateString(Scanner sc, int max, String message) {
        System.out.println(message);
        while (true) {
            try {
                String input = sc.nextLine();
                if (input.length() <= max && !input.isEmpty()) {
                    return input;
                }else{
                    System.out.println("dữ liệu không được vượt quá " +max + "hoạc không được để trống");
                }
            } catch (Exception e) {
                System.err.println("lỗi chưa đúng định dạng dữ liệu");
            }
        }
    }
    public static boolean validateBoolean(Scanner sc,String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim().toLowerCase();
            if (input.equals("true") || input.equals("false")) {
                return Boolean.parseBoolean(input);
            }
            System.out.println("không dúng dịnh dạng .");
        }
    }
    public static LocalDate validateDate(String message, Scanner scanner) {
        System.out.println(message);
        do {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            try {
                return LocalDate.parse(scanner.nextLine(), dtf);
            } catch (DateTimeParseException dte) {
                System.err.println("Định dạng ngày tháng không đúng, vui lòng nhập lại");
            } catch (Exception ex) {
                System.err.println("Có lỗi trong quá trình nhập dữ liệu, vui lòng nhập lại");
            }
        } while (true);
    }
}
