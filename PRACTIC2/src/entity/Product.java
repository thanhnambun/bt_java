package entity;

import imp.ProductImp;

import java.util.Scanner;

public class Product {
    private String productId;
    private String productName;
    private float importPrice;
    private float exportPrice;
    private float profit;
    private int quantity;
    private String descriptions;
    private boolean status;

    public Product() {
    }

    public Product(String productId, String productName, float importPrice,
                   float exportPrice, int quantity, String descriptions, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.quantity = quantity;
        this.descriptions = descriptions;
        this.status = status;
        this.profit = this.exportPrice - this.importPrice;
    }

    // Các getter/setter
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public float getProfit() {
        return profit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    private boolean isDuplicateProductId(String id) {
        for (Product product : ProductImp.productList) {
            if (product != null && product.getProductId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    private boolean isDuplicateProductName(String name) {
        for (Product product : ProductImp.productList) {
            if (product != null && product.getProductName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void inputData(Scanner sc) {
        sc.nextLine();

        System.out.println("Vui lòng nhập mã sản phẩm (4 ký tự):");
        while (true) {
            String id = sc.nextLine();
            if (id.length() == 4 && !isDuplicateProductId(id)) {
                this.productId = id;
                break;
            }
            System.out.println("Mã sản phẩm bị lỗi (trùng hoặc sai định dạng)! Nhập lại:");
        }

        System.out.println("Vui lòng nhập tên sản phẩm (6-50 ký tự):");
        while (true) {
            String name = sc.nextLine();
            if (name.length() >= 6 && name.length() <= 50 && !isDuplicateProductName(name)) {
                this.productName = name;
                break;
            }
            System.out.println("Tên sản phẩm bị lỗi (trùng hoặc sai độ dài)! Nhập lại:");
        }

        System.out.println("Vui lòng nhập giá nhập (lớn hơn 0):");
        while (true) {
            try {
                float importPrice = Float.parseFloat(sc.nextLine());
                if (importPrice > 0) {
                    this.importPrice = importPrice;
                    break;
                }
            } catch (NumberFormatException e) {
            }
            System.out.println("Giá nhập không hợp lệ! Nhập lại:");
        }

        System.out.println("Vui lòng nhập giá xuất (lớn hơn ít nhất 20% so với giá nhập):");
        while (true) {
            try {
                float exportPrice = Float.parseFloat(sc.nextLine());
                if (exportPrice >= this.importPrice * 1.2f) {
                    this.exportPrice = exportPrice;
                    break;
                }
            } catch (NumberFormatException e) {
            }
            System.out.println("Giá xuất không hợp lệ! Nhập lại:");
        }

        calProfit();

        System.out.println("Vui lòng nhập số lượng sản phẩm (lớn hơn 0):");
        while (true) {
            try {
                int quantity = Integer.parseInt(sc.nextLine());
                if (quantity > 0) {
                    this.quantity = quantity;
                    break;
                }
            } catch (NumberFormatException e) {
            }
            System.out.println("Số lượng không hợp lệ! Nhập lại:");
        }

        System.out.println("Nhập mô tả sản phẩm:");
        this.descriptions = sc.nextLine();

        System.out.println("Nhập trạng thái sản phẩm (true - Đang bán, false - Không bán):");
        while (true) {
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
                this.status = Boolean.parseBoolean(input);
                break;
            }
            System.out.println("Trạng thái không hợp lệ! Nhập lại (true/false):");
        }
    }

    public void calProfit() {
        this.profit = this.exportPrice - this.importPrice;
    }

    public void displayData() {
        System.out.println("-----------------------------------");
        System.out.println("Mã SP: " + productId);
        System.out.println("Tên SP: " + productName);
        System.out.println("Giá nhập: " + importPrice);
        System.out.println("Giá xuất: " + exportPrice);
        System.out.println("Lợi nhuận: " + profit);
        System.out.println("Số lượng: " + quantity);
        System.out.println("Mô tả: " + descriptions);
        System.out.println("Trạng thái: " + (status ? "Đang bán" : "Không bán"));
        System.out.println("-----------------------------------");
    }
}
