package service;

import data.Data;

import java.util.Scanner;

public class CategoryService {

    private Scanner scanner;

    public CategoryService() {
        this.scanner = scanner;
    }

    public static void showAllCategories() {
        if (Data.categoryCount == 0) {
            System.out.println("chưa có danh mục nào được thêm ");
            return;
        } else {
            for (int i = 0; i < Data.categoryCount; i++) {
                Data.categoriesList[i].displayData();
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
                            Data.categoriesList[index].setNameCategories(newNameCategories);
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
                            Data.categoriesList[index].setDescriptionCategories(newDescription);
                            System.out.println("Đã cập nhật mô tả danh mục.");
                            break;
                        }
                    } while (true);
                    break;

                case 4:
                    System.out.println("Vui lòng nhập trạng thái danh mục (true/false):");
                    boolean status = Boolean.parseBoolean(scanner.nextLine());
                    Data.categoriesList[index].setStatusCategories(status);
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
            if (Data.categoriesList[i].getNameCategories().contains(name)) {
                Data.categoriesList[i].displayData();
                check = true;
            } else {
                check = false;
            }
        }
        if (check == false) {
            System.out.println("không tìm thấy tên của danh mục ");
        }
    }
}
