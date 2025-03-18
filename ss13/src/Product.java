import java.util.Scanner;

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

    public Product(){}

    public Product(String productId, String productName, float importPrice, float exportPrice, String title, String description, int quantity, int categoryId, int productStatus) {
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

        while (true) {
            System.out.print("Nhập mã sản phẩm (5 ký tự, bắt đầu bằng C/E/T): ");
            String id = scanner.nextLine().trim();

            if (id.length() != 5 || !(id.startsWith("C") || id.startsWith("E") || id.startsWith("T"))) {
                System.out.println("Mã sản phẩm phải có 5 ký tự và bắt đầu bằng C, E hoặc T.");
                continue;
            }


            for (int i = 0; i < Data.productCount; i++) {
                if (Data.productList[i].getProductId().equals(id)) {
                    System.out.println("mã sản phẩm đã tồn tại vui lòng nhập lại ");
                }
            }
            this.productId = id;
            break;
        }

        while (true) {
            System.out.print("Nhập tên sản phẩm (10-100 ký tự): ");
            String name = scanner.nextLine().trim();

            if (name.length() < 10 || name.length() > 100) {
                System.out.println("Tên sản phẩm phải từ 10 đến 100 ký tự.");
                continue;
            }
            for (int i = 0; i < Data.productCount; i++) {
                if (Data.productList[i].getProductName().contains(name)) {
                    System.out.println("Tên sản phẩm đã tồn tại, vui lòng nhập tên khác.");
                    continue;
                }
            }

            this.productName = name;
            break;
        }

        while (true) {
            System.out.print("Nhập giá nhập sản phẩm (> 0): ");
            try {
                float importPrice = Float.parseFloat(scanner.nextLine());
                if (importPrice <= 0) {
                    System.out.println("Giá nhập phải lớn hơn 0.");
                    continue;
                }
                this.importPrice = importPrice;
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ.");
            }
        }

        while (true) {
            System.out.print("Nhập giá xuất sản phẩm (>= " + (this.importPrice * INTEREST) + "): ");
            try {
                float exportPrice = Float.parseFloat(scanner.nextLine());
                if (exportPrice < this.importPrice * INTEREST) {
                    System.out.println("Giá xuất phải lớn hơn hoặc bằng " + (this.importPrice * INTEREST));
                    continue;
                }
                this.exportPrice = exportPrice;
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ.");
            }
        }

        while (true) {
            System.out.print("Nhập tiêu đề sản phẩm (tối đa 200 ký tự): ");
            String title = scanner.nextLine().trim();
            if (title.length() > 200) {
                System.out.println("Tiêu đề không được vượt quá 200 ký tự.");
                continue;
            }
            this.title = title;
            break;
        }

        System.out.print("Nhập mô tả sản phẩm: ");
        this.description = scanner.nextLine();

        while (true) {
            System.out.print("Nhập số lượng sản phẩm: ");
            try {
                this.quantity = Integer.parseInt(scanner.nextLine());
                if (quantity < 0) {
                    System.out.println("Số lượng không được âm.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên.");
            }
        }
        System.out.println("Danh sách các danh mục sản phẩm là:");
        for (int i = 0; i < Data.categoryCount; i++) {
            System.out.println((i + 1) + ". " + Data.categoriesList[i].getNameCategoriies());
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

        while (true) {
            System.out.print("Nhập trạng thái sản phẩm (0: Đang hoạt động – 1: hết hàng – 2: không hoạt động): ");
            try {
                int status = Integer.parseInt(scanner.nextLine());
                if (status < 0 || status > 2) {
                    System.out.println("Trạng thái chỉ nhận giá trị 0, 1 hoặc 2.");
                    continue;
                }
                this.productStatus = status;
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên.");
            }
        }
    }


    @Override
    public void disPlayData() {
        System.out.println("----- Thông tin sản phẩm -----");
        System.out.println("Mã sản phẩm: " + productId);
        System.out.println("Tên sản phẩm: " + productName);
        System.out.println("Giá nhập: " + importPrice);
        System.out.println("Giá xuất: " + exportPrice);
        System.out.println("Tiêu đề: " + title);
        System.out.println("Mô tả: " + description);
        System.out.println("Số lượng: " + quantity);
        System.out.println("Mã danh mục: " + categoryId);

        String statusString = "";
        switch (productStatus) {
            case 0:
                statusString = "Đang hoạt động";
                break;
            case 1:
                statusString = "Hết hàng";
                break;
            case 2:
                statusString = "Không hoạt động";
                break;
        }
        System.out.println("Trạng thái: " + statusString);
    }
}
