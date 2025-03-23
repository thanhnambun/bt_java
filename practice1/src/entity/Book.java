package entity;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Pattern;

import static run.BookImp.bookArrayList;

public class Book {
    private String bookId;
    private String bookName;
    private float importPrice;
    private float exportPrice;
    private String author;
    private float interest;
    private int year;

    // Constructor không tham số
    public Book() {
    }

    // Constructor đầy đủ tham số
    public Book(String bookId, String bookName, float importPrice, float exportPrice, String author, int year) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.author = author;
        this.year = year;
        this.interest = this.exportPrice - this.importPrice;
    }

    // Getter và Setter
    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getInterest() {
        return interest;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public static boolean isBookExist(String type, String value) {
        switch (type) {
            case "bookId":
                return bookArrayList.stream()
                        .anyMatch(b -> b.getBookId().equalsIgnoreCase(value));
            case "bookName":
                return bookArrayList.stream()
                        .anyMatch(b -> b.getBookName().equalsIgnoreCase(value));
            default:
                return false;
        }
    }

    public static float inoutFloat(double min, float price) {
        if (price < min) {
            System.out.println("lỗi");
            return -1;
        }
        return price;
    }

    public void inputData(Scanner scanner) {
        System.out.print("Nhập mã sách (duy nhất): ");
        while (true) {
            String id = scanner.nextLine().trim();
            if (!isBookExist("bookId", id)) {
                this.bookId = id;
                break;
            }

            System.err.println("Mã sách đã tồn tại hoặc không hợp lệ! Nhập lại:");
        }
        System.out.print("Nhập tên sách (duy nhất): ");
        while (true) {
            String nameBook = scanner.nextLine().trim();
            if (!isBookExist("bookName", nameBook) && Pattern.matches("(B)\\w(4)", nameBook)) {
                this.bookName = nameBook;
                break;
            }

            System.err.println("Tên sách đã tồn tại hoặc không hợp lệ! Nhập lại:");
        }

        System.out.println("vui lòng nhập giá nhập");
        while (true) {
            float price = scanner.nextFloat();
            if (inoutFloat(0,price) == -1){
                break;
            }
            this.importPrice = price;
        }
        System.out.println("vui lòng nhập giá nhập");
        while (true) {
            float price = scanner.nextFloat();
            if (inoutFloat(1.3*price,price) == -1){
                break;
            }
            this.importPrice = price;
        }
        System.out.println("vui lòng nhập tên tác giả");
        while (true) {
            String author = scanner.nextLine().trim();
            if(author.length()>6 && author.length()<50){
                this.author = author;
                break;
            }
            System.out.println("tên tác giả oddungs hãy nhập lại ");
        }
        this.interest = this.importPrice - this.exportPrice;
        System.out.println("vui lòng nhập năm sản xuất ");
        while (true) {
            int year = scanner.nextInt();
            if (year<2000){
                this.year = year;
            }
            System.out.println("năm sản xuất không đúng,vui lòng nhập lại ");
        }
    }

    public void displayData() {
        System.out.printf("Mã sách: %s | Tên sách: %s | Giá nhập: %.2f | Giá xuất: %.2f | Tác giả: %s | Lợi nhuận: %.2f | Năm XB: %d\n",
                this.bookId, this.bookName, this.importPrice, this.exportPrice, this.author, this.interest, this.year);
    }
}
