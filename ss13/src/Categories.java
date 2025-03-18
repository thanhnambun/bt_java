import java.util.Scanner;

public class Categories implements IApp {
    protected int idCategories;
    protected String nameCategories;
    protected int priorityCategories;
    protected String descriptionCategoriies;
    protected boolean statusCategoriies;
    protected int count =0;



    public Categories(int idCategories, int priorityCategories, String nameCategories, String descriptionCategoriies, boolean statusCategoriies) {
        this.idCategories = idCategories;
        this.priorityCategories = priorityCategories;
        this.nameCategories = nameCategories;
        this.descriptionCategoriies = descriptionCategoriies;
        this.statusCategoriies = statusCategoriies;
    }

    public int getIdCategories() {
        return idCategories;
    }

    public void setIdCategories(int idCategories) {
        this.idCategories = idCategories;
    }

    public String getNameCategoriies() {
        return nameCategories;
    }

    public void setNameCategoriies(String nameCategoriies) {
        this.nameCategories = nameCategoriies;
    }

    public int getPriorityCategories() {
        return priorityCategories;
    }

    public void setPriorityCategories(int priorityCategories) {
        this.priorityCategories = priorityCategories;
    }

    public String getDescriptionCategoriies() {
        return descriptionCategoriies;
    }

    public void setDescriptionCategoriies(String descriptionCategoriies) {
        this.descriptionCategoriies = descriptionCategoriies;
    }

    public boolean isStatusCategoriies() {
        return statusCategoriies;
    }

    public void setStatusCategoriies(boolean statusCategoriies) {
        this.statusCategoriies = statusCategoriies;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("vui lòng nhập những thông tin của Categories");
        this.idCategories = count++;
        do {
            System.out.println("vui lòng nhập tên danh mục (từ 6-50 kí tự )");
            this.nameCategories = scanner.nextLine();
            if (this.nameCategories.length() < 6 || this.nameCategories.length() > 50) {
                System.out.println("Tên danh mục phải có từ 6-50 kí tự, vui lòng nhập lại!");
            }else {
                break;
            }
        }while (true);

        System.out.println("vui lòng nhập mức độ ưu tiên ");
        this.priorityCategories = Integer.parseInt(scanner.nextLine());
        do {
            System.out.println("Vui lòng nhập mô tả danh mục: ");
            this.descriptionCategoriies = scanner.nextLine();
            if (this.descriptionCategoriies.length() >255) {
                System.out.println("mô tả danh mục quá dài !. Vui lòng nhập lại .");
            }else{
                break;
            }
        }while (true);
        System.out.println("Vui lòng nhập trạng thái danh mục (true/false): ");
        this.statusCategoriies = Boolean.parseBoolean(scanner.nextLine());
    }

    @Override
    public void disPlayData() {
        System.out.println("--------- Thông tin danh mục ---------");
        System.out.println("ID danh mục: " + idCategories);
        System.out.println("Tên danh mục: " + nameCategories);
        System.out.println("Mức độ ưu tiên: " + priorityCategories);
        System.out.println("Mô tả danh mục: " + descriptionCategoriies);
        System.out.println("Trạng thái danh mục: " + (statusCategoriies ? "Hoạt động" : "Không hoạt động"));
    }
}
