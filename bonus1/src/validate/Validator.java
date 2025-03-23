package validate;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validator {
    public static String setID(Scanner scanner, String message, String regex) {
        System.out.println(message);
        do {
            String inputString = scanner.nextLine();
            if (Pattern.matches(regex, inputString)) {
                return inputString;
            }
            System.err.println("Dữ liệu không hợp lệ, vui lòng nhập lại");
        } while (true);
    }

    public static String setBookTitle(Scanner sc , String message) {
        String name;
        do {
            System.out.print(message);
            name = sc.nextLine().trim();
            if (!name.isEmpty()) {
                return name;
            }
            System.err.println("Không được để trống.");
        } while (true);
    }

    public static String setAuthor(Scanner sc , String message) {
        String author;
        do {
            System.out.print(message);
            author = sc.nextLine().trim();
            if (author == null || author.trim().isEmpty() || author.length() < 50) {
                return author;
            }
        }while (true);
    }

    public static String setPublisherOrCategory (Scanner sc , String message) {
        String publisher;
        do {
            System.out.print(message);
            publisher = sc.nextLine().trim();
            if (publisher == null || publisher.trim().isEmpty() || publisher.length() < 100) {
                return publisher;
            }else {
                System.out.println("không được để trống và tối đa 100 ký tự");
            }
        }while (true);
    }

    public static int setPublicationYearOrQuantity(Scanner sc , String message) {
        int publicationYear;
        do {
            System.out.print(message);
            publicationYear = sc.nextInt();
            if (publicationYear <= 0) {
                System.out.println("lỗi" );
            }else {
                return publicationYear;
            }
        }while (true);
    }

    public static double setPrice(Scanner sc , String message) {
        double price;
        do {
            System.out.print(message);
            price = sc.nextDouble();
            if (price <= 0) {
                System.out.println("Giá sách không hợp lệ (phải lớn hơn 0).");
            }else {
                return price;
            }
        }while (true);
    }
}
