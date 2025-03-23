package bussiness;

import entity.Book;

import java.util.Comparator;
import java.util.Scanner;

import static presentation.BookApplication.bookArrayList;

public class BookBusiness {

    public static void displayBooks() {
        if (bookArrayList.isEmpty()) {
            System.out.println("Danh sách trống");
        } else {
            System.out.println("danh sách sác");
            for (Book book : bookArrayList) {
                book.displayData();
            }
        }
    }

    public static void addBooks(Scanner sc) {
        Book bookNew = new Book();
        bookNew.inputData(sc);
        bookArrayList.add(bookNew);
    }

    public static void removeBooks(Scanner sc) {
        System.out.println("Vui lòng nhập mã sách cần xóa: ");
        String bookId = sc.nextLine();
        Book book = findById(bookId);
        if (book == null) {
            System.out.println("Không tìm thấy sách.");
            return;
        }
        System.out.println("Bạn có chắc chắn muốn xóa sách này không? (Y/N)");
        String confirm = sc.nextLine();
        if (confirm.equalsIgnoreCase("Y")) {
            bookArrayList.remove(book);
            System.out.println("Xóa sách thành công.");
        } else {
            System.out.println("Đã hủy thao tác xóa.");
        }
    }

    private static Book findById(String id) {
        return bookArrayList.stream().filter(b -> b.getId().equalsIgnoreCase(id)).findFirst().orElse(null);
    }

    public static void updateBook(Scanner sc) {
        System.out.println("Nhập mã sách cần chỉnh sửa:");
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
        System.out.println("Cập nhật thành công.");
    }

    public static void searchBook(Scanner sc) {
        System.out.println("1. Tìm theo tiêu đề");
        System.out.println("2. Tìm theo thể loại");
        System.out.println("3. Tìm theo khoảng giá");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1:
                System.out.println("Nhập tiêu đề:");
                String title = sc.nextLine();
                bookArrayList.stream().filter(b -> b.getBookTitle().equalsIgnoreCase(title))
                        .forEach(Book::displayData);
                break;
            case 2:
                System.out.println("Nhập thể loại:");
                String category = sc.nextLine();
                bookArrayList.stream().filter(b -> b.getCategory().equalsIgnoreCase(category))
                        .forEach(Book::displayData);
                break;
            case 3:
                System.out.println("Nhập giá thấp nhất:");
                double min = Double.parseDouble(sc.nextLine());
                System.out.println("Nhập giá cao nhất:");
                double max = Double.parseDouble(sc.nextLine());
                bookArrayList.stream().filter(b -> b.getPrice() >= min && b.getPrice() <= max)
                        .forEach(Book::displayData);
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ");
        }
    }

    public static void sortBooks(Scanner sc) {
        System.out.println("1. Sắp xếp theo tiêu đề tăng dần");
        System.out.println("2. Sắp xếp theo tiêu đề giảm dần");
        System.out.println("3. Sắp xếp theo giá tăng dần");
        System.out.println("4. Sắp xếp theo giá giảm dần");
        int choice = Integer.parseInt(sc.nextLine());

        switch (choice) {
            case 1:
                bookArrayList.sort(Comparator.comparing(Book::getBookTitle));
                break;
            case 2:
                bookArrayList.sort(Comparator.comparing(Book::getBookTitle).reversed());
                break;
            case 3:
                bookArrayList.sort(Comparator.comparingDouble(Book::getPrice));
                break;
            case 4:
                bookArrayList.sort(Comparator.comparingDouble(Book::getPrice).reversed());
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
                return;
        }
        System.out.println("Danh sách sau khi sắp xếp:");
        displayBooks();
    }

}
