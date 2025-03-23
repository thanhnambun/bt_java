package entity;

import validate.Validator;

import java.util.Scanner;

public class Book implements IApp {
    private String id;
    private String bookTitle;
    private String bookAuthor;
    private String publisher;
    private int publicationYear;
    private String category;
    private double price;
    private int quantity;

    public Book() {
    }

    public Book(String id, String bookTitle, String bookAuthor, String publisher, int publicationYear, String category, double price, int quantity) {
        this.id = id;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public void inputData(Scanner sc) {
        this.id = intputId(sc);
        System.out.println("Nhập tiêu đề sách:");
        this.bookTitle = Validator.inputString(sc, 100);

        System.out.println("Nhập tác giả:");
        this.bookAuthor = Validator.inputString(sc, 50);

        System.out.println("Nhập nhà xuất bản:");
        this.publisher = Validator.inputString(sc, 100);

        System.out.println("Nhập năm xuất bản:");
        this.publicationYear = Validator.inputPositiveInt(sc);

        System.out.println("Nhập thể loại:");
        this.category = Validator.inputString(sc, 100);

        System.out.println("Nhập giá sách:");
        this.price = Validator.inputPositiveDouble(sc);

        System.out.println("Nhập số lượng sách:");
        this.quantity = Validator.inputPositiveInt(sc);
    }

    @Override
    public void displayData() {
        System.out.printf("| ID: %s | Title: %s | Author: %s | Publisher: %s | Year: %d | Category: %s | Price: %.2f | Quantity: %d |\n",
                id, bookTitle, bookAuthor, publisher, publicationYear, category, price, quantity);
    }
    public String intputId(Scanner sc) {
        String id = Validator.validateId(sc,"vui lòng nhập id");
        return Validator.isIdExit(sc,id);
    }


}
