package validate;

import entity.Book;
import presentation.BookApplication;

import java.util.Scanner;
import java.util.regex.Pattern;


public class Validator {
    public static String isIdExit(Scanner sc,String value) {
        for(Book b:BookApplication.bookArrayList){
            if(b.getId().equals(value)){
                return "id đã tồn tại";
            }
        }
        return value;
    }
    public static String validateId(Scanner scanner, String message) {
        System.out.println(message);
        do {
            String inputString = scanner.nextLine();
            if (Pattern.matches("(B)\\w(5)", inputString)) {
                return inputString;
            }
            System.err.println("Dữ liệu không hợp lệ, vui lòng nhập lại");
        } while (true);
    }

    public static String inputString(Scanner sc, int maxLength) {
        String input;
        do {
            input = sc.nextLine().trim();
            if (input.isEmpty() || input.length() > maxLength) {
                System.out.printf("Không được để trống và tối đa %d ký tự. Nhập lại:\n", maxLength);
            } else {
                break;
            }
        } while (true);
        return input;
    }

    public static int inputPositiveInt(Scanner sc) {
        int num;
        do {
            try {
                num = Integer.parseInt(sc.nextLine());
                if (num <= 0) {
                    System.out.println("Phải nhập số lớn hơn 0. Nhập lại:");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Không đúng định dạng. Nhập lại:");
            }
        } while (true);
        return num;
    }

    public static double inputPositiveDouble(Scanner sc) {
        double num;
        do {
            try {
                num = Double.parseDouble(sc.nextLine());
                if (num <= 0) {
                    System.out.println("Phải nhập số lớn hơn 0. Nhập lại:");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Không đúng định dạng. Nhập lại:");
            }
        } while (true);
        return num;
    }
}
