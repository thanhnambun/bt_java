package entity;

import java.util.Scanner;
import data.Data;

public class Product implements IApp {

    private String productId;
    private String productName;
    private float importPrice;
    private float exportPrice;
    private String title;
    private String description;
    private int quantity;
    private int categoryId;
    private int productStatus;

    // Constructors
    public Product() {
    }

    public Product(String productId, String productName, float importPrice, float exportPrice,
                   String title, String description, int quantity, int categoryId, int productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.title = title;
        this.description = description;
        this.quantity = quantity;
        this.categoryId = categoryId;
        this.productStatus = productStatus;
    }

    // Getter & Setter
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhập mã sản phẩm (C/E/T và 5 ký tự): ");
        while (true) {
            String id = scanner.nextLine().trim();
            if (id.length() != 5 || !(id.startsWith("C") || id.startsWith("E") || id.startsWith("T"))) {
                System.out.println("Mã sản phẩm không hợp lệ, nhập lại: ");
            } else {
                this.productId = id;
                break;
            }
        }

        System.out.println("Nhập tên sản phẩm (10-100 ký tự): ");
        while (true) {
            String name = scanner.nextLine();
            if (name.length() < 10 || name.length() > 100) {
                System.out.println("Tên sản phẩm không hợp lệ, nhập lại: ");
            } else {
                this.productName = name;
                break;
            }
        }

        System.out.println("Nhập giá nhập (>0): ");
        while (true) {
            try {
                float price = Float.parseFloat(scanner.nextLine());
                if (price > 0) {
                    this.importPrice = price;
                    break;
                } else {
                    System.out.println("Giá nhập phải lớn hơn 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số.");
            }
        }

        System.out.println("Nhập giá xuất (>= importPrice * INTEREST): ");
        while (true) {
            try {
                float price = Float.parseFloat(scanner.nextLine());
                if (price >= importPrice * INTEREST) {
                    this.exportPrice = price;
                    break;
                } else {
                    System.out.println("Giá xuất phải >= " + (importPrice * INTEREST));
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số.");
            }
        }

        System.out.println("Nhập tiêu đề sản phẩm (tối đa 200 ký tự): ");
        while (true) {
            String title = scanner.nextLine();
            if (title.length() > 200) {
                System.out.println("Tiêu đề quá dài, nhập lại:");
            } else {
                this.title = title;
                break;
            }
        }

        System.out.println("Nhập mô tả sản phẩm: ");
        this.description = scanner.nextLine();

        System.out.println("Nhập số lượng sản phẩm (>=0): ");
        while (true) {
            try {
                int qty = Integer.parseInt(scanner.nextLine());
                if (qty >= 0) {
                    this.quantity = qty;
                    break;
                } else {
                    System.out.println("Số lượng phải >= 0");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số.");
            }
        }

        System.out.println("Danh sách các danh mục sản phẩm là:");
        for (int i = 0; i < Data.categoryCount; i++) {
            System.out.println((i + 1) + ". " + Data.categoriesList[i].getNameCategories());
        }

        System.out.print("Nhập mã danh mục (số nguyên): ");
        boolean foundCategory = false;
        for (int i = 0; i < Data.categoryCount; i++) {
            if (Data.categoriesList[i].getIdCategories() == categoryId) {
                foundCategory = true;
                break;
            }
        }
        if (foundCategory) {
            this.categoryId = categoryId;
        } else {
            System.out.println("Mã danh mục không tồn tại, vui lòng nhập lại.");
        }

        System.out.println("Nhập trạng thái sản phẩm (0: Đang hoạt động, 1: Hết hàng, 2: Không hoạt động): ");
        while (true) {
            int status = Integer.parseInt(scanner.nextLine());
            if (status >= 0 && status <= 2) {
                this.productStatus = status;
                break;
            } else {
                System.out.println("Trạng thái không hợp lệ.");
            }
        }
    }

    @Override
    public void displayData() {
        System.out.println("Mã sản phẩm: " + productId);
        System.out.println("Tên sản phẩm: " + productName);
        System.out.println("Giá nhập: " + importPrice);
        System.out.println("Giá xuất: " + exportPrice);
        System.out.println("Tiêu đề: " + title);
        System.out.println("Mô tả: " + description);
        System.out.println("Số lượng: " + quantity);
        System.out.println("Mã danh mục: " + categoryId);

        String statusText;
        switch (productStatus) {
            case 0:
                statusText = "Đang hoạt động";
                break;
            case 1:
                statusText = "Hết hàng";
                break;
            case 2:
                statusText = "Không hoạt động";
                break;
            default:
                statusText = "Không xác định";
        }
        System.out.println("Trạng thái: " + statusText);
    }
}
