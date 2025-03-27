package entity;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

public class Product implements IProduct {
    private Optional<Integer> productId;
    private Optional<String> productName;
    private float price;
    private String category;
    private LocalDate createdDate;

    public Product(){}

    public Product(Optional<Integer> productId, Optional<String> productName, float price, String category, LocalDate createdDate) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.createdDate = createdDate;
    }

    public Optional<Integer> getProductId() {
        return productId;
    }

    public void setProductId(Optional<Integer> productId) {
        this.productId = productId;
    }

    public Optional<String> getProductName() {
        return productName;
    }

    public void setProductName(Optional<String> productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public void inputdata(Scanner sc) {
        System.out.println("vui lòng nhập id");
        this.productId = Optional.of(sc.nextInt());
        System.out.println("vui lòng nhập tên ");
        this.productName = Optional.of(sc.next());
        System.out.println("vui lòng nhập price");
        while (true){
            price = sc.nextFloat();
            if(price>0){
                this.price = price;
                break;
            }
            System.out.println("vui lòng nhập lại .");
        }
        System.out.println("vui lòng nhập danh mục sản phẩm ");
        this.category = sc.next();
        System.out.println("vui lon nhập ngày tạo ");
        this.createdDate= LocalDate.parse(sc.next());
    }

    @Override
    public void display() {
        System.out.println("id :"+this.productId+"name:"+this.productName+"price:"+this.price+"category:"+this.category+"createddate:"+this.createdDate);
    }
}
