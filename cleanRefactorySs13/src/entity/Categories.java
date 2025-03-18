package entity;

import java.util.Scanner;

public class Categories implements IApp {

    private static int AUTO_ID = 1;

    private int idCategories;
    private String nameCategories;
    private int priorityCategories;
    private String descriptionCategories;
    private boolean statusCategories;

    // Constructors
    public Categories() {
        this.idCategories = AUTO_ID++;
    }

    public Categories(String nameCategories, int priorityCategories, String descriptionCategories, boolean statusCategories) {
        this.idCategories = AUTO_ID++;
        this.nameCategories = nameCategories;
        this.priorityCategories = priorityCategories;
        this.descriptionCategories = descriptionCategories;
        this.statusCategories = statusCategories;
    }

    // Getter & Setter
    public int getIdCategories() {
        return idCategories;
    }

    public String getNameCategories() {
        return nameCategories;
    }

    public void setNameCategories(String nameCategories) {
        this.nameCategories = nameCategories;
    }

    public int getPriorityCategories() {
        return priorityCategories;
    }

    public void setPriorityCategories(int priorityCategories) {
        this.priorityCategories = priorityCategories;
    }

    public String getDescriptionCategories() {
        return descriptionCategories;
    }

    public void setDescriptionCategories(String descriptionCategories) {
        this.descriptionCategories = descriptionCategories;
    }

    public boolean isStatusCategories() {
        return statusCategories;
    }

    public void setStatusCategories(boolean statusCategories) {
        this.statusCategories = statusCategories;
    }

    // Implement methods from IApp
    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhập tên danh mục (6-50 ký tự): ");
        while (true) {
            String name = scanner.nextLine();
            if (name.length() < 6 || name.length() > 50) {
                System.out.println("Tên danh mục không hợp lệ, nhập lại: ");
            } else {
                this.nameCategories = name;
                break;
            }
        }

        System.out.println("Nhập độ ưu tiên: ");
        this.priorityCategories = Integer.parseInt(scanner.nextLine());

        System.out.println("Nhập mô tả danh mục (tối đa 255 ký tự): ");
        while (true) {
            String description = scanner.nextLine();
            if (description.length() > 255) {
                System.out.println("Mô tả quá dài, nhập lại: ");
            } else {
                this.descriptionCategories = description;
                break;
            }
        }

        System.out.print("Nhập trạng thái danh mục (1: Hoạt động, 0: Không hoạt động): ");
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equals("1")) {
                this.statusCategories = true;
                break;
            } else if (input.equals("0")) {
                this.statusCategories = false;
                break;
            } else {
                System.out.print("Giá trị không hợp lệ! Vui lòng nhập 1 hoặc 0: ");
            }
        }
    }

    @Override
    public void displayData() {
        System.out.println("----- Thông tin danh mục -----");
        System.out.printf("Mã danh mục     : %d\n", idCategories);
        System.out.printf("Tên danh mục    : %s\n", nameCategories);
        System.out.printf("Độ ưu tiên      : %d\n", priorityCategories);
        System.out.printf("Mô tả           : %s\n", descriptionCategories);
        System.out.printf("Trạng thái      : %s\n", statusCategories ? "Hoạt động" : "Không hoạt động");
    }
}
