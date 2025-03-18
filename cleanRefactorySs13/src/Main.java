import service.CategoryService;
import service.ProductService;

import java.util.Scanner;

public class Main {

    private final Scanner scanner;
    private final CategoryService categoryService;
    private final ProductService productService;

    public Main() {
        scanner = new Scanner(System.in);
        categoryService = new CategoryService();
        productService = new ProductService();
    }

    public void displayMainMenu() {
        while (true) {
            System.out.println("*********************SHOP MENU*********************");
            System.out.println("1. Quản lý danh mục");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");
            System.out.print("Chọn chức năng: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    displayCategoryMenu();
                    break;
                case "2":
                    displayProductMenu();
                    break;
                case "3":
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private void displayCategoryMenu() {
        while (true) {
            System.out.println("********************CATEGORY MANAGEMENT*********************");
            System.out.println("1. Danh sách danh mục");
            System.out.println("2. Thêm mới danh mục");
            System.out.println("3. Cập nhật danh mục");
            System.out.println("4. Xóa danh mục");
            System.out.println("5. Tìm kiếm danh mục theo tên");
            System.out.println("6. Quay lại menu chính");
            System.out.print("Chọn chức năng: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên!");
                continue;
            }

            switch (choice) {
                case 1:
                    categoryService.showAllCategories();
                    break;
                case 2:
                    categoryService.addCategory(scanner);
                    break;
                case 3:
                    categoryService.updateCategory(scanner);
                    break;
                case 4:
                    categoryService.deleteCategory(scanner);
                    break;
                case 5:
                    categoryService.searchCategoryByName(scanner);
                    break;
                case 6:
                    System.out.println("Quay lại menu chính...");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private void displayProductMenu() {
        while (true) {
            System.out.println("************************PRODUCT MANAGEMENT*******************");
            System.out.println("1. Danh sách sản phẩm");
            System.out.println("2. Thêm mới sản phẩm");
            System.out.println("3. Cập nhật sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm theo tên hoặc tiêu đề");
            System.out.println("6. Tìm kiếm sản phẩm theo khoảng giá bán");
            System.out.println("7. Sắp xếp sản phẩm theo giá bán tăng dần");
            System.out.println("8. Bán sản phẩm");
            System.out.println("9. Thống kê số lượng sản phẩm theo danh mục");
            System.out.println("10. Quay lại menu chính");
            System.out.print("Chọn chức năng: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên!");
                continue;
            }

            switch (choice) {
                case 1:
                    productService.showProduct();
                    break;
                case 2:
                    productService.addProduct(scanner);
                    break;
                case 3:
                    productService.updateProduct(scanner);
                    break;
                case 4:
                    productService.deleteProduct(scanner);
                    break;
                case 5:
                    productService.searchProductByTitle(scanner);
                    break;
                case 6:
                    productService.searchProductByPrice(scanner);
                    break;
                case 7:
                    productService.sortProductByExportPriceAsc();
                    break;
                case 8:
                    productService.sellProduct(scanner);
                    break;
                case 9:
                    productService.statisticProductByCategory();
                    break;
                case 10:
                    System.out.println("Quay lại menu chính...");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    public static void main(String[] args) {
        Main shopApp = new Main();
        shopApp.displayMainMenu();
    }
}
