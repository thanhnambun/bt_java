import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int choice;

    public static void main(String[] args) {

        do {
            System.out.println("*********************SHOP MENU*********************");
            System.out.println("1. Quản lý danh mục");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    do {
                        System.out.println("********************CATEGORIE MANAGEMENT*********************");
                        System.out.println("1. Danh sách danh mục");
                        System.out.println("2. Thêm mới danh mục");
                        System.out.println("3. Cập nhật danh mục");
                        System.out.println("4. Xóa danh mục");
                        System.out.println("5. Tìm kiếm danh mục theo tên");
                        System.out.println("6. Thoát");
                        System.out.print("Chọn chức năng: ");
                        choice = Integer.parseInt(scanner.nextLine());

                        switch (choice) {
                            case 1:
                                showAllCategories();
                                break;
                            case 2:
                                addCategory(scanner);
                                break;
                            case 3:
                                updateCategory(scanner);
                                break;
                            case 4:
                                deleteCategory(scanner);
                                break;
                            case 5:
                                searchCategoryByName(scanner);
                                break;
                            case 6:
                                System.out.println("Quay lại menu chính...");
                                break;
                            default:
                                System.out.println("Lựa chọn không hợp lệ!");
                        }
                    } while (choice != 6);
                    break;
                case 2:
                    do {
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
                        System.out.println("10. Thoát");
                        System.out.print("Chọn chức năng: ");
                        choice = Integer.parseInt(scanner.nextLine());

                        switch (choice) {
                            case 1:
                                showProduct();
                                break;
                            case 2:
                                addProduct(scanner);
                                break;
                            case 3:
                                updateProduct(scanner);
                                break;
                            case 4:
                                deleteProduct(scanner);
                                break;
                            case 5:
                                searchProductByTitle(scanner);
                                break;
                            case 6:
                                searchProductByPrice(scanner);
                                break;
                            case 7:
                                sortProductByExportPriceAsc();
                                break;
                            case 8:
                                sellProduct(scanner);
                                break;
                            case 9:
                                statisticProductByCategory();
                                break;
                            case 10:
                                System.out.println("Quay lại menu chính...");
                                break;
                            default:
                                System.out.println("Lựa chọn không hợp lệ!");
                        }
                    } while (choice != 10);
                    break;
                case 3:
                    System.out.println("Đã thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 3);
    }

    public static void showAllCategories() {
        if (Data.categoryCount == 0) {
            System.out.println("chưa có danh mục nào được thêm ");
            return;
        } else {
            for (int i = 0; i < Data.categoryCount; i++) {
                Data.categoriesList[i].disPlayData();
            }
        }
    }

    public static void addCategory(Scanner scanner) {
        Data.categoriesList[Data.categoryCount].inputData(scanner);
        Data.categoryCount++;
    }

    public static int searchCategoryById(int id) {
        for (int i = 0; i < Data.categoryCount; i++) {
            if (Data.categoriesList[i].getIdCategories() == id) {
                return i;
            }
        }
        return -1;
    }

    public static void updateCategory(Scanner scanner) {
        System.out.println("Vui lòng nhập mã danh mục cần sửa đổi:");
        int categoryId = Integer.parseInt(scanner.nextLine());

        int index = searchCategoryById(categoryId);
        if (index == -1) {
            System.out.println("Không tìm thấy ID của danh mục cần sửa.");
            return;
        }

        int choice;
        do {
            System.out.println("1. Sửa tên danh mục");
            System.out.println("2. Sửa độ ưu tiên");
            System.out.println("3. Sửa mô tả danh mục");
            System.out.println("4. Sửa trạng thái danh mục");
            System.out.println("5. Thoát");
            System.out.print("Vui lòng lựa chọn thay đổi: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    do {
                        System.out.println("Vui lòng nhập tên danh mục (6-50 ký tự):");
                        String newNameCategories = scanner.nextLine();
                        if (newNameCategories.length() < 6 || newNameCategories.length() > 50) {
                            System.out.println("Tên danh mục phải có từ 6-50 ký tự, vui lòng nhập lại!");
                        } else {
                            Data.categoriesList[index].setNameCategoriies(newNameCategories);
                            System.out.println("Đã cập nhật tên danh mục.");
                            break;
                        }
                    } while (true);
                    break;

                case 2:
                    System.out.println("Vui lòng nhập mức độ ưu tiên:");
                    int priority = Integer.parseInt(scanner.nextLine());
                    Data.categoriesList[index].setPriorityCategories(priority);
                    System.out.println("Đã cập nhật mức độ ưu tiên.");
                    break;

                case 3:
                    do {
                        System.out.println("Vui lòng nhập mô tả danh mục (tối đa 255 ký tự):");
                        String newDescription = scanner.nextLine();
                        if (newDescription.length() > 255) {
                            System.out.println("Mô tả danh mục quá dài! Vui lòng nhập lại.");
                        } else {
                            Data.categoriesList[index].setDescriptionCategoriies(newDescription);
                            System.out.println("Đã cập nhật mô tả danh mục.");
                            break;
                        }
                    } while (true);
                    break;

                case 4:
                    System.out.println("Vui lòng nhập trạng thái danh mục (true/false):");
                    boolean status = Boolean.parseBoolean(scanner.nextLine());
                    Data.categoriesList[index].setStatusCategoriies(status);
                    System.out.println("Đã cập nhật trạng thái danh mục.");
                    break;

                case 5:
                    System.out.println("Thoát sửa danh mục.");
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (true);
    }


    public static int searchCategoryByIdfromProduct(int id) {
        int index = searchCategoryById(id);
        if (index == -1) {
            return -1;
        }

        for (int i = 0; i < Data.productCount; i++) {
            if (Data.productList[i].getCategoryId() == id) {
                return -1;
            }
        }

        return index;
    }

    public static void deleteCategory(Scanner scanner) {
        System.out.println("Vui lòng nhập mã danh mục cần xóa:");
        int categoryId = Integer.parseInt(scanner.nextLine());

        int index = searchCategoryByIdfromProduct(categoryId);
        if (index == -1) {
            System.out.println("Không thể xóa. Mã danh mục không tồn tại hoặc đang có sản phẩm.");
            return;
        }
        for (int i = index; i < Data.categoryCount - 1; i++) {
            Data.categoriesList[i] = Data.categoriesList[i + 1];
        }
        Data.categoriesList[Data.categoryCount - 1] = null;
        Data.categoryCount--;
        System.out.println("Đã xóa danh mục thành công!");
    }

    public static void searchCategoryByName(Scanner scanner) {
        System.out.println("vui lòng nhập tên cần tìm kiếm ");
        String name = scanner.nextLine();
        boolean check = false;
        for (int i = 0; i < Data.categoryCount; i++) {
            if (Data.categoriesList[i].getNameCategoriies().contains(name)) {
                Data.categoriesList[i].disPlayData();
                check = true;
            } else {
                check = false;
            }
        }
        if (check == false) {
            System.out.println("không tìm thấy tên của danh mục ");
        }
    }

    public static void showProduct() {
        for (int i = 0; i < Data.productCount; i++) {
            Data.productList[i].disPlayData();
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
                Data.productList[i].disPlayData();
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
                Data.productList[i].disPlayData();
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

            System.out.println("Danh mục: " + Data.categoriesList[i].getNameCategoriies() + " có " + count + " sản phẩm.");
        }
    }

}
