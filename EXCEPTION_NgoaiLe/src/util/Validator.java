package util;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validator {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$");

    public static int validateInt(Scanner sc) {
        while (true) {
            System.out.println("vui lòng nhập vào 1 số nguyên");
            try {
                int number = Integer.parseInt(sc.nextLine());return number;
            } catch (Exception e) {
                System.out.println("không đúng định dạng ");
            }
        }
    }

    public static float validateFloat(Scanner sc) {
        while (true) {
            System.out.println("vui lòng nhập vào 1 số thực ");
            try {
                float number = Float.parseFloat(sc.nextLine());
                return number;
            } catch (Exception e) {
                System.out.println(" lỗi nhập không đúng dịnhd dạng 1 số thực ");
            }
        }
    }

    public static double validateDouble(Scanner sc) {
        while (true) {
            System.out.println("vui lòng nhập 1 số thực kiểu double");
            try {
                double number = Double.parseDouble(sc.nextLine());
                return number;
            } catch (Exception e) {
                System.out.println("không đúng định dạng kiểu double");
            }
        }
    }

    public static boolean validateBoolean(Scanner sc) {
        while (true) {
            System.out.print("vui lòng nhập true,false");
            String input = sc.nextLine().trim().toLowerCase();
            if (input.equals("true") || input.equals("false")) {
                return Boolean.parseBoolean(input);
            }
            System.out.println("không dúng dịnh dạng .");
        }
    }
    public static String validateString(Scanner sc, int min, int max) {
        while (true) {
            System.out.println("vui lòng nhâp 1 chuỗi cần kiểm  tra từ  " + min + "đến " + max);
            try {
                String string = sc.nextLine().trim();
                if (string.isEmpty() && string.length() < min || string.length() > max) {
                    System.out.println("vui lòng nhập lại ");
                    break;
                }
                return  string;
            } catch (Exception e) {
                System.out.println("không đúng định dạng của chuỗi ");
            }
        }
    }

    public static String validateEmail(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            String email = scanner.nextLine().trim();
            if (EMAIL_PATTERN.matcher(email).matches()) {
                return email;
            }
            System.out.println("khoogn đúng định dạng của email.");
        }
    }
    public static String  validatePhone(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            String phone = scanner.nextLine().trim();
            if (PHONE_PATTERN.matcher(phone).matches()) {
                return phone;
            }
            System.out.println("khoogn đúng định dạng của email.");
        }
    }
}
