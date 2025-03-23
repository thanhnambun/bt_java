package bussiness;

import entity.Book;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import static presentation.BookApplication.bookArrayList;

public class BookBusiness {

    public static void displayBooks() {
        if (bookArrayList.isEmpty()) {
            System.out.println("Danh sách trống.");
        } else {
            System.out.println("Danh sách sách:");
            for (Book book : bookArrayList) {
                book.displayData();
            }
        }
    }

    public static void addBooks(Scanner sc) {
        Book bookNew = new Book();
        bookNew.inputData(sc);
        bookArrayList.add(bookNew);
        System.out.println("Thêm sách thành công!");
    }

    public static void removeBooks(Scanner sc) {
        System.out.print("Nhập mã sách cần xóa: ");
        String bookId = sc.nextLine();

        Book book = findById(bookId);
        if (book == null) {
            System.out.println("Không tìm thấy sách có mã: " + bookId);
            return;
        }

        System.out.print("Bạn có chắc chắn muốn xóa sách này không? (Y/N): ");
        String confirm = sc.nextLine();

        if (confirm.equalsIgnoreCase("Y")) {
            bookArrayList.remove(book);
            System.out.println("Đã xóa sách thành công.");
        } else {
            System.out.println("Đã hủy thao tác xóa.");
        }
    }

    private static Book findById(String id) {
        for (Book book : bookArrayList) {
            if (book.getId().equalsIgnoreCase(id)) {
                return book;
            }
        }
        return null;
    }

    public static void updateBook(Scanner sc) {
        System.out.print("Nhập mã sách cần cập nhật: ");
        String id = sc.nextLine();

        Book book = findById(id);
        if (book == null) {
            System.out.println("Không tìm thấy sách.");
            return;
        }

        System.out.println("Thông tin hiện tại:");
        book.displayData();

        System.out.println("Nhập thông tin mới:");
        book.inputData(sc);

        System.out.println("Cập nhật sách thành công.");
    }

    public static void searchBook(Scanner sc) {
        System.out.println("1. Tìm theo tiêu đề");
        System.out.println("2. Tìm theo thể loại");
        System.out.println("3. Tìm theo khoảng giá");

        int choice = Integer.parseInt(sc.nextLine());
        boolean found = false;

        switch (choice) {
            case 1 -> {
                System.out.print("Nhập tiêu đề sách: ");
                String title = sc.nextLine();
                for (Book book : bookArrayList) {
                    if (book.getBookTitle().equalsIgnoreCase(title)) {
                        book.displayData();
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("Không tìm thấy sách có tiêu đề: " + title);
                }
            }
            case 2 -> {
                System.out.print("Nhập thể loại sách: ");
                String category = sc.nextLine();
                for (Book book : bookArrayList) {
                    if (book.getCategory().equalsIgnoreCase(category)) {
                        book.displayData();
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("Không tìm thấy sách thuộc thể loại: " + category);
                }
            }
            case 3 -> {
                System.out.print("Nhập giá thấp nhất: ");
                double min = Double.parseDouble(sc.nextLine());
                System.out.print("Nhập giá cao nhất: ");
                double max = Double.parseDouble(sc.nextLine());

                for (Book book : bookArrayList) {
                    if (book.getPrice() >= min && book.getPrice() <= max) {
                        book.displayData();
                        found = true;
                    }
                }

                if (!found) {
                    System.out.println("Không tìm thấy sách trong khoảng giá từ " + min + " đến " + max);
                }
            }
            default -> System.out.println("Lựa chọn không hợp lệ.");
        }
    }

    public static void sortBooks(Scanner sc) {
        System.out.println("1. Sắp xếp theo tiêu đề tăng dần");
        System.out.println("2. Sắp xếp theo tiêu đề giảm dần");
        System.out.println("3. Sắp xếp theo giá tăng dần");
        System.out.println("4. Sắp xếp theo giá giảm dần");

        int choice = Integer.parseInt(sc.nextLine());

        switch (choice) {
            case 1 -> {
                Collections.sort(bookArrayList, Comparator.comparing(Book::getBookTitle, String.CASE_INSENSITIVE_ORDER));
                System.out.println("Đã sắp xếp tiêu đề tăng dần.");
            }
            case 2 -> {
                Collections.sort(bookArrayList, Comparator.comparing(Book::getBookTitle, String.CASE_INSENSITIVE_ORDER).reversed());
                System.out.println("Đã sắp xếp tiêu đề giảm dần.");
            }
            case 3 -> {
                Collections.sort(bookArrayList, Comparator.comparingDouble(Book::getPrice));
                System.out.println("Đã sắp xếp giá tăng dần.");
            }
            case 4 -> {
                Collections.sort(bookArrayList, Comparator.comparingDouble(Book::getPrice).reversed());
                System.out.println("Đã sắp xếp giá giảm dần.");
            }
            default -> {
                System.out.println("Lựa chọn không hợp lệ.");
                return;
            }
        }

        System.out.println("Danh sách sách sau khi sắp xếp:");
        displayBooks();
    }

}
