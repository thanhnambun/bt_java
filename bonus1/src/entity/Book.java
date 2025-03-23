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
        this.id = inputId(sc);
        this.bookTitle = inputBookTitle(sc);
        this.bookAuthor = inputBookAuthor(sc);
        this.publisher = inputPublication(sc);
        this.category = inputCategory(sc);
        this.publicationYear = inputPublicationYear(sc);
        this.quantity = inputQuantity(sc);
        this.price = inputPrice(sc);
    }

    @Override
    public void displayData() {


    }

    public String inputId(Scanner sc) {
        return Validator.setID(sc, "vui lòng nhập mã sách", "(B)\\w(5)");
    }

    public String inputBookTitle(Scanner sc) {
        return Validator.setBookTitle(sc, "vui lòng nhâập tên sahc");
    }

    public String inputBookAuthor(Scanner sc) {
        return Validator.setAuthor(sc, "vui lòng nhập tên tác giả ");
    }

    public String inputPublication(Scanner sc) {
        return Validator.setPublisherOrCategory(sc, "vui lòng nhập nhà xuất bản");
    }

    public Integer inputPublicationYear(Scanner sc) {
        return Validator.setPublicationYearOrQuantity(sc, "vui lòng nhập năm sản xuất ");
    }

    public String inputCategory(Scanner sc) {
        return Validator.setPublisherOrCategory(sc, "vui lòng nhaaoj thể loại");
    }

    public double inputPrice(Scanner sc) {
        return Validator.setPrice(sc, "vui lòng nhập giá");
    }

    public Integer inputQuantity(Scanner sc) {
        return Validator.setPublicationYearOrQuantity(sc, "vui lòng nhập số lượng sanr phẩm ");
    }
}
