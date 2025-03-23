package imp;

import entity.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductImp {
    public static List<Product> productList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("MENU");
            System.out.println("1. Nhập thông tin n sản phẩm");
            System.out.println("2. Hiển thị thông tin các sản phẩm");
            System.out.println("3. Tính lợi nhuận các sản phẩm");
            System.out.println("4. Sắp xếp các sản phẩm theo lợi nhuận giảm dần");
            System.out.println("5. Thống kê các sản phẩm theo giá");
            System.out.println("6. Tìm các sản phẩm theo tên sản phẩm");
            System.out.println("7. Nhập sản phẩm");
            System.out.println("8. Bán sản phẩm");
            System.out.println("9. Cập nhật trạng thái sản phẩm");
            System.out.println("10. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> inputProducts(sc);
                case 2 -> displayProducts();
                case 3 -> calculateProfits();
                case 4 -> sortProductsByProfitDesc();
                case 5 -> statisticProductsByPrice(sc);
                case 6 -> findProductByName(sc);
                case 7 -> importProductQuantity(sc);
                case 8 -> sellProduct(sc);
                case 9 -> updateProductStatus(sc);
                case 10 -> System.out.println("Thoát chương trình!");
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 10);
    }

    public static void inputProducts(Scanner sc) {
        System.out.print("Nhập số lượng sách cần thêm: ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.printf("Nhập thông tin cho sách thứ %d:\n", i + 1);
            Product products = new Product();
            products.inputData(sc);
            productList.add(products);
        }
    }

    public static void displayProducts() {
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    public static void calculateProfits() {
        for (Product product : productList) {
            System.out.println(product.getProfit());
        }
    }

    public static void sortProductsByProfitDesc() {
        productList.sort((p1, p2) -> Float.compare(p2.getProfit(), p1.getProfit()));
    }

    public static void statisticProductsByPrice(Scanner sc) {
        System.out.println("vui lòng nhập giá (min,max) ");
        int max = Integer.parseInt(sc.nextLine());
        int min = Integer.parseInt(sc.nextLine());
        for (Product product : productList) {
            if (product.getExportPrice() < max && product.getExportPrice() > min) {
                product.displayData();
            }
        }
    }

    public static void findProductByName(Scanner sc) {
        String name = sc.nextLine();
        for (Product product : productList) {
            if (product.getProductName().equals(name)) {
                System.out.println(product);
            }
        }
    }

    public static void importProductQuantity(Scanner sc) {
        System.out.println("vui lòng nhập id của sản phẩm ");
        String id = sc.nextLine();
        System.out.println("vui lòng nhập số luowjgn sản phẩm");
        int quantity = Integer.parseInt(sc.nextLine());
        for (Product product : productList) {
            if (product.getProductId().equals(id)) {
                product.setQuantity(quantity + product.getQuantity());
            }
        }
    }

    public static void sellProduct(Scanner sc) {
        System.out.println("vui lòng nhập sản phẩm cần bán ");
        String name = sc.nextLine();
        System.out.println("vui lòng nhập số lượng cần bán");
        int quantity = Integer.parseInt(sc.nextLine());
        for (Product product : productList) {
            if (product.getProductName().equals(name)) {
                if (quantity > product.getQuantity()) {
                    System.out.println("lỗi số lượng bán nhiều hơn số lượng còn ");
                } else {
                    product.setQuantity(product.getQuantity() - quantity);
                }
            }
        }
    }

    public static void updateProductStatus(Scanner sc) {
        System.out.println("vui lòng nhập id của sản phẩm ");
        String id = sc.nextLine();
        for (Product product : productList) {
            if (product.getProductId().equals(id)) {
                product.setStatus(!product.isStatus());
            }
        }
    }

}
