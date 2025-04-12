package presentation;

import business.dao.department.DepartmentDao;
import business.model.Department;
import business.model.Status;
import business.service.department.DepartmentService;
import business.service.department.DerpartmentServiceImp;
import validate.StringRule;
import validate.Validator;

import java.util.List;
import java.util.Scanner;

public class DepartmentUI {
    public static void displayMenuDepartment(Scanner sc) {
        DepartmentService departmentService = new DerpartmentServiceImp();
        int choice;
        do {
            System.out.println("1. danh sách phòng ban ");
            System.out.println("2. thêm mới phòng ban ");
            System.out.println("3. Cập nhật phòng ban");
            System.out.println("4. Xóa phòng ban  ");
            System.out.println("5. Tìm kiếm phòng ban");
            System.out.println("6. Thoát");
            System.out.printf("vui lòng chọn");
            choice = Validator.validateChoice(sc);
            switch (choice) {
                case 1:
                    showDepartmentPages(sc,departmentService);
                    break;
                case 2:
                    addDepartment(sc,departmentService);
                    break;
                case 3:
                    updateDepartment(sc,departmentService);
                    break;
                case 4:
                    deleteDepartment(sc,departmentService);
                    break;
                case 5:
                    searchDepartment(sc,departmentService);
                    break;
                case 6:
                    System.out.println("đã thoát khỏi quản lý phòng ban ");
                    System.exit(0);
                    break;
                default:
                    System.out.println("vui lòng chọn từ 1-6");
                    break;
            }
        } while (true);
    }

    public static void showDepartmentPages(Scanner sc, DepartmentService departmentService) {
        int totalPages = departmentService.getTotalDepartmentPages();
        int currentPage = 1;

        while (true) {
            System.out.println("\n--- Danh sách phòng ban - Trang " + currentPage + "/" + totalPages + " ---");

            List<Department> departments = departmentService.getDepartmentsByPage(currentPage);
            if (departments.isEmpty()) {
                System.out.println("Không có phòng ban nào trong trang này.");
            } else {
                for (Department department : departments) {
                    System.out.println("- Tên: " + department.getNameDepartment()
                            + " | Mô tả: " + department.getDescription()
                            + " | Trạng thái: " + department.getStatusDepartment());
                }
            }
            System.out.println("\nChọn hành động:");
            System.out.println("1. Trang trước");
            System.out.println("2. Trang sau");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    if (currentPage > 1) {
                        currentPage--;
                    } else {
                        System.out.println("Đang ở trang đầu tiên.");
                    }
                    break;
                case "2":
                    if (currentPage < totalPages) {
                        currentPage++;
                    } else {
                        System.out.println("Đang ở trang cuối cùng.");
                    }
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
        }
    }
    public static void addDepartment(Scanner sc,DepartmentService departmentService) {
        Department department = new Department();
        department.inputData(sc);
        departmentService.addDepartment(department);
    }
    public static void updateDepartment(Scanner sc,DepartmentService departmentService) {
        int choice;
        System.out.println("vui lòng nhập id của phòng ban cần sửa ");
        int id = Integer.parseInt(sc.nextLine());
        Department department = departmentService.getById(id);
        if (department != null) {
            do {
                System.out.println("1.sửa tên phòng ban");
                System.out.println("2.sửa trạng thái phòng ban");
                System.out.println("3.thoát");
                choice = Validator.validateChoice(sc);
                if (choice == 1) {
                    String newName=Validator.validateString(sc,"vui lòng nhập tên phòng ban",new StringRule(100,10));
                    department.setNameDepartment(newName);
                    departmentService.update(department);
                }else if (choice == 2) {
                    Status status = Validator.validateStatus(sc,"vui lòng nhập trạng thái phòng ban",Status.class);
                    department.setStatusDepartment(status);
                    departmentService.update(department);
                }else if (choice == 3) {
                    System.out.println("đã thoát chỉnh sửa ");
                    break;
                }else {
                    System.out.println("vui lòng cho từ 1-3");
                }
            }while (true);
        }else {
            System.out.println("không tìm thấy phòng ban có id như trên");
        }
    }
    public static void deleteDepartment(Scanner sc,DepartmentService departmentService) {
        System.out.println("vui lòng nhập id ");
        int id = Integer.parseInt(sc.nextLine());
        Department department = departmentService.getById(id);
        if (department != null) {
            int checkEmployees= departmentService.searchEmployess(id);
            if (checkEmployees == 0) {
                departmentService.delete(department);
            }else {
                System.out.println("không thể xóa phòng ban có nhân viên được");
            }
        }
    }
    public static void searchDepartment(Scanner sc,DepartmentService departmentService) {
        String newName=Validator.validateString(sc,"vui lòng nhập tên phòng ban",new StringRule(100,10));
        List<Department> department = departmentService.sreach(newName);
        if (department != null) {
            department.stream().forEach(System.out::println);
        }else {
            System.out.println("không tìm tháấy phòng ban có tên như trên");
        }
    }
}

