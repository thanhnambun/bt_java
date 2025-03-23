package run;

import entity.Book;

import java.util.ArrayList;
import java.util.Scanner;

public class BookImp {
    public static ArrayList<Book> bookArrayList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("*********************MENU******************");
            System.out.println("1. Nhập thông tin n sách");
            System.out.println("2. Tính lợi nhuận các sách");
            System.out.println("3. Hiển thị thông tin sách");
            System.out.println("4. Sắp xếp sách theo giá bán tăng dần");
            System.out.println("5. Sắp xếp sách theo lợi nhuận giảm dần");
            System.out.println("6. Tìm sách theo tên sách");
            System.out.println("7. Thống kê số lượng sách theo năm xuất bản");
            System.out.println("8. Thống kê số lượng sách theo tác giả");
            System.out.println("9. Thoát");
            System.out.print("Nhập lựa chọn: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    inputBooks(sc);
                    break;
                case 2:
                    calculateInterestBooks();
                    break;
                case 3:
                    displayBooks();
                    break;
                case 4:
                    sortBooksByPriceAsc();
                    displayBooks();
                    break;
                case 5:
                    sortBooksByInterestDesc();
                    displayBooks();
                    break;
                case 6:
                    findBookByName(sc);
                    break;
                case 7:
                    statisticByYear(sc);
                    break;
                case 8:
                    statisticByAuthor(sc);
                    break;
                case 9:
                    System.out.println("Thoát chương trình...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 9);
    }

    private static void inputBooks(Scanner sc) {
        System.out.print("Nhập số lượng sách cần thêm: ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.printf("Nhập thông tin cho sách thứ %d:\n", i + 1);
            Book book = new Book();
            book.inputData(sc);
            bookArrayList.add(book);
        }
    }

    private static void calculateInterestBooks() {
        System.out.println("Danh sách lợi nhuận của các sách:");
        for (Book book : bookArrayList) {
            System.out.println("Tên sách: " + book.getBookName() + " - Lợi nhuận: " + book.getInterest());
        }
    }

    private static void displayBooks() {
        if (bookArrayList.isEmpty()) {
            System.out.println("Danh sách sách trống!");
        } else {
            for (Book book : bookArrayList) {
                book.displayData();
            }
        }
    }

    private static void sortBooksByPriceAsc() {
        for (int i = 0; i < bookArrayList.size() - 1; i++) {
            for (int j = i + 1; j < bookArrayList.size(); j++) {
                if (bookArrayList.get(i).getExportPrice() > bookArrayList.get(j).getExportPrice()) {
                    Book temp = bookArrayList.get(i);
                    bookArrayList.set(i, bookArrayList.get(j));
                    bookArrayList.set(j, temp);
                }
            }
        }
        System.out.println("Đã sắp xếp sách theo giá bán tăng dần.");
    }

    private static void sortBooksByInterestDesc() {
        for (int i = 0; i < bookArrayList.size() - 1; i++) {
            for (int j = i + 1; j < bookArrayList.size(); j++) {
                if (bookArrayList.get(i).getInterest() < bookArrayList.get(j).getInterest()) {
                    Book temp = bookArrayList.get(i);
                    bookArrayList.set(i, bookArrayList.get(j));
                    bookArrayList.set(j, temp);
                }
            }
        }
        System.out.println("Đã sắp xếp sách theo lợi nhuận giảm dần.");
    }

    private static void findBookByName(Scanner sc) {
        System.out.print("Nhập tên sách cần tìm: ");
        String nameBook = sc.nextLine();
        boolean found = false;
        for (Book book : bookArrayList) {
            if (book.getBookName().equalsIgnoreCase(nameBook)) {
                book.displayData();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sách với tên: " + nameBook);
        }
    }

    private static void statisticByYear(Scanner sc) {
        System.out.print("Nhập năm cần thống kê: ");
        int year = Integer.parseInt(sc.nextLine());
        int count = 0;
        for (Book book : bookArrayList) {
            if (book.getYear() == year) {
                count++;
            }
        }
        System.out.printf("Có %d sách được xuất bản năm %d.\n", count, year);
    }

    private static void statisticByAuthor(Scanner sc) {
        System.out.print("Nhập tên tác giả cần thống kê: ");
        String author = sc.nextLine();
        int count = 0;
        for (Book book : bookArrayList) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                count++;
            }
        }
        System.out.printf("Có %d sách của tác giả %s.\n", count, author);
    }
}
