package entity;

import org.w3c.dom.ls.LSOutput;

import java.time.Year;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Book {
    private String bookId;
    private String bookName;
    private float importPrice;
    private float exportPrice;
    private String title;
    private String author;
    private float interest;
    private Year year;

    public Book() {
    }

    public Book(String bookId, String bookName, float importPrice, float exportPrice, String title, String author, float interest, Year year) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.title = title;
        this.author = author;
        this.interest = interest;
        this.year = year;
    }

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public float calInterest(){
        return this.exportPrice - this.importPrice;
    }

    public void inputData(Scanner sc) {
        String bookIdRegex = "^B\\d{4}$";
        do {
            System.out.println("Vui lòng nhập id (5 ký tự bắt đầu là ký tự B): ");
            this.bookId = sc.nextLine();
            if (Pattern.matches(bookIdRegex, this.bookId)) {
                break;
            } else {
                System.err.println("Định dạng mã sách không đúng, ví dụ B0001. Vui lòng nhập lại.");
            }
        } while (true);

        do {
            System.out.println("Vui lòng nhập tên sách (từ 6-100 kí tự): ");
            this.bookName = sc.nextLine();
            if (this.bookName.length() >= 6 && this.bookName.length() <= 100) {
                break;
            } else {
                System.err.println("Tên sách không hợp lệ, vui lòng nhập lại!");
            }
        } while (true);

        do {
            System.out.println("Vui lòng nhập giá nhập sách (lớn hơn 0): ");
            this.importPrice = sc.nextFloat();
            sc.nextLine();
            if (this.importPrice > 0) {
                break;
            } else {
                System.err.println("Giá nhập phải lớn hơn 0!");
            }
        } while (true);

        do {
            System.out.println("Vui lòng nhập giá bán sách (phải lớn hơn ít nhất 10% giá nhập): ");
            this.exportPrice = sc.nextFloat();
            sc.nextLine();
            if (this.exportPrice >= this.importPrice * 1.1) {
                break;
            } else {
                System.out.println("Giá bán đang bị lỗ! Bạn có muốn nhập lại giá bán không? (1.Có / 2.Không)");
                int choice = sc.nextInt();
                sc.nextLine();
                if (choice == 2) {
                    break;
                }
            }
        } while (true);

        do {
            System.out.println("Vui lòng nhập tiêu đề sách:");
            this.title = sc.nextLine();
            if (this.title != null && !this.title.trim().isEmpty()) {
                break;
            } else {
                System.err.println("Tiêu đề không được để trống!");
            }
        } while (true);

        do {
            System.out.println("Vui lòng nhập tên tác giả:");
            this.author = sc.nextLine();
            if (this.author != null && !this.author.trim().isEmpty()) {
                break;
            } else {
                System.err.println("Tên tác giả không được để trống!");
            }
        } while (true);

        do {
            try {
                System.out.println("Vui lòng nhập năm xuất bản (trên năm 1970): ");
                int inputYear = Integer.parseInt(sc.nextLine());
                if (inputYear > 1970) {
                    this.year = Year.of(inputYear);
                    break;
                } else {
                    System.err.println("Năm xuất bản phải lớn hơn 1970!");
                }
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập đúng định dạng năm!");
            }
        } while (true);

        this.interest = calInterest();
    }

    public void display() {
        System.out.println("----- Thông tin sách -----");
        System.out.println("Mã sách: " + this.bookId);
        System.out.println("Tên sách: " + this.bookName);
        System.out.println("Giá nhập: " + this.importPrice);
        System.out.println("Giá bán: " + this.exportPrice);
        System.out.println("Tiêu đề: " + this.title);
        System.out.println("Tác giả: " + this.author);
        System.out.println("Năm xuất bản: " + this.year);
        System.out.println("Lợi nhuận: " + this.interest);
        System.out.println("--------------------------");
    }

}
