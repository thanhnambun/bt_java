package service;

import data.Data;
import entity.Product;
import java.util.Scanner;

public class ProductService {
    public static void showProduct() {
        for (int i = 0; i < Data.productCount; i++) {
            Data.productList[i].displayData();
        }
    }

    public static void addProduct(Scanner scanner) {
        Data.productList[Data.productCount].inputData(scanner);
        Data.productCount++;
    }

    public static int searchProductById(String id) {
        for (int i = 0; i < Data.productCount; i++) {
            if (Data.productList[i].getProductId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public static void updateProduct(Scanner scanner) {
        System.out.print("Nhập mã sản phẩm cần cập nhật: ");
        String id = scanner.nextLine();
        int index = searchProductById(id);

        if (index == -1) {
            System.out.println("Không tìm thấy sản phẩm với mã: " + id);
            return;
        }

        Product product = Data.productList[index];

        while (true) {
            System.out.println("1. Cập nhật tên sản phẩm");
            System.out.println("2. Cập nhật giá nhập");
            System.out.println("3. Cập nhật giá xuất");
            System.out.println("4. Cập nhật tiêu đề");
            System.out.println("5. Cập nhật mô tả");
            System.out.println("6. Cập nhật số lượng");
            System.out.println("7. Cập nhật mã danh mục");
            System.out.println("8. Cập nhật trạng thái");
            System.out.println("9. Thoát cập nhật");
            System.out.print("Chọn chức năng: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhập tên mới: ");
                    String newName = scanner.nextLine();
                    product.setProductName(newName);
                    break;
                case 2:
                    System.out.print("Nhập giá nhập mới: ");
                    float newImport = Float.parseFloat(scanner.nextLine());
                    product.setImportPrice(newImport);
                    break;
                case 3:
                    System.out.print("Nhập giá xuất mới: ");
                    float newExport = Float.parseFloat(scanner.nextLine());
                    product.setExportPrice(newExport);
                    break;
                case 4:
                    System.out.print("Nhập tiêu đề mới: ");
                    String newTitle = scanner.nextLine();
                    product.setTitle(newTitle);
                    break;
                case 5:
                    System.out.print("Nhập mô tả mới: ");
                    String newDesc = scanner.nextLine();
                    product.setDescription(newDesc);
                    break;
                case 6:
                    System.out.print("Nhập số lượng mới: ");
                    int newQty = Integer.parseInt(scanner.nextLine());
                    product.setQuantity(newQty);
                    break;
                case 7:
                    System.out.print("Nhập mã danh mục mới: ");
                    int newCat = Integer.parseInt(scanner.nextLine());
                    product.setCategoryId(newCat);
                    break;
                case 8:
                    System.out.print("Nhập trạng thái mới (0: hoạt động, 1: hết hàng, 2: không hoạt động): ");
                    int newStatus = Integer.parseInt(scanner.nextLine());
                    product.setProductStatus(newStatus);
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    public static void deleteProduct(Scanner scanner) {
        System.out.println("vui lòng nhập mã của sản phẩm caafn xóa ");
        String id = scanner.nextLine();
        int index = searchProductById(id);
        if (index == -1) {
            System.out.println("kooong tìm thấy mã của sản phaarm");
            return;
        }
        for (int i = index; i < Data.productCount; i++) {
            Data.productList[i] = Data.productList[i + 1];
        }
        Data.productList[Data.productCount - 1] = null;
        Data.productCount--;
        System.out.println("đã xóa thành công sản phẩm");
    }

    public static void searchProductByTitle(Scanner scanner) {
        System.out.println("vui lòng nhập tiêu đề sản phẩm cần tìm kiếm ");
        String title = scanner.nextLine();
        boolean check = true;
        for (int i = 0; i < Data.productCount; i++) {
            if (Data.productList[i].getProductName().equals(title)) {
                Data.productList[i].displayData();
                check = false;
            }
        }
        if (check) {
            System.out.println("không tìm thấy tiêu dề của sản phẩm");
        }
    }

    public static void searchProductByPrice(Scanner scanner) {
        System.out.println("vui lòng nhập khoảng giá cần tìm kiếm (Min , Max)");
        float maxPrice = Float.parseFloat(scanner.nextLine());
        float minPrice = Float.parseFloat(scanner.nextLine());
        boolean check = true;
        for (int i = 0; i < Data.productCount; i++) {
            if (Data.productList[i].getExportPrice() < maxPrice && Data.productList[i].getExportPrice() > minPrice) {
                Data.productList[i].displayData();
            }
        }
    }

    public static void sortProductByExportPriceAsc() {
        for (int i = 0; i < Data.productCount - 1; i++) {
            for (int j = i + 1; j < Data.productCount; j++) {
                if (Data.productList[i].getExportPrice() > Data.productList[j].getExportPrice()) {
                    Product temp = Data.productList[i];
                    Data.productList[i] = Data.productList[j];
                    Data.productList[j] = temp;
                }
            }
        }
        System.out.println("Đã sắp xếp sản phẩm theo giá xuất tăng dần!");
    }

    public static void sellProduct(Scanner scanner) {
        System.out.println("vui lòng nhập id của sản phẩm");
        String id = scanner.nextLine();
        int index = searchProductById(id);
        if (index == -1) {
            System.out.println("không tìm thấy mã của sản phẩm ");
        }
        Product product = Data.productList[index];

        System.out.println("vui lòng nhập số lượng cần bán");
        int sellQuantity = Integer.parseInt(scanner.nextLine());
        product.setQuantity(product.getQuantity() - sellQuantity);
        System.out.println("Bán hàng thành công! Số lượng còn lại: " + product.getQuantity());

        if (product.getQuantity() == 0) {
            product.setProductStatus(1);
            System.out.println("Sản phẩm đã hết hàng.");
        }

    }

    public static void statisticProductByCategory() {
        if (Data.categoryCount == 0) {
            System.out.println("Chưa có danh mục nào!");
            return;
        }

        for (int i = 0; i < Data.categoryCount; i++) {
            int categoryId = Data.categoriesList[i].getIdCategories();
            int count = 0;

            for (int j = 0; j < Data.productCount; j++) {
                if (Data.productList[j].getCategoryId() == categoryId) {
                    count++;
                }
            }

            System.out.println("Danh mục: " + Data.categoriesList[i].getNameCategories() + " có " + count + " sản phẩm.");
        }
    }
}
