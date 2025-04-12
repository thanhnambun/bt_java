package presentation;

import business.model.Department;
import business.model.Employess;
import business.model.Sex;
import business.model.StatusEmployess;
import business.service.department.DepartmentService;
import business.service.department.DerpartmentServiceImp;
import business.service.employe.EmployeesService;
import business.service.employe.EmployeesServiceImp;
import validate.EmployessValidator;
import validate.StringRule;
import validate.Validator;

import java.util.List;
import java.util.Scanner;

public class EmployessUI {
    private final EmployeesService employeesService ;
    public EmployessUI() {
        employeesService = new EmployeesServiceImp();
    }

    public static void displayMenu(Scanner sc) {
        EmployeesService employeesService = new EmployeesServiceImp();
        EmployessUI  employessUI = new EmployessUI();
        DepartmentService departmentService = new DerpartmentServiceImp();
        int choice;
        do {
            System.out.println("\n==== QUẢN LÝ NHÂN VIÊN ====");
            System.out.println("1. Hiển thị danh sách nhân viên theo trang");
            System.out.println("2. Thêm nhân viên mới");
            System.out.println("3. Cập nhật nhân viên");
            System.out.println("4. Xóa nhân viên");
            System.out.println("5. Tìm nhân viên theo độ tuổi");
            System.out.println("6. Sắp xếp nhân viên theo lương giảm dần");
            System.out.println("7. Sắp xếp nhân viên theo tên tăng dần");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> showEmployeePages(sc, employeesService);
                case 2 -> employessUI.addEmployee(sc, departmentService);
                case 3 -> employessUI.updateEmployee(sc);
                case 4 -> employessUI.deleteEmployee(sc);
                case 5 -> employessUI.searchByAge(sc);
                case 6 -> employessUI.sortBySalary();
                case 7 -> employessUI.sortByName();
                case 0 -> System.out.println("Thoát chương trình.");
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (choice != 0);
    }

    public static void showEmployeePages(Scanner sc, EmployeesService employeesService) {
        int totalPages = employeesService.getTotalEmployessPages();
        int currentPage = 1;

        while (true) {
            System.out.println("\n--- Danh sách nhân viên - Trang " + currentPage + "/" + totalPages + " ---");

            List<Employess> employees = employeesService.getEmployeesByPage(currentPage);
            if (employees.isEmpty()) {
                System.out.println("Không có nhân viên nào trong trang này.");
            } else {
                for (Employess emp : employees) {
                    System.out.println("- ID: " + emp.getIdEmployess()
                            + " | Tên: " + emp.getNameEmployess()
                            + " | Email: " + emp.getEmailEmployess()
                            + " | SĐT: " + emp.getPhoneEmployess()
                            + " | Lương: " + emp.getSalaryEmployess()
                            + " | Trạng thái: " + emp.getStatusEmployess());
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

    private void addEmployee(Scanner sc, DepartmentService departmentService) {
        Employess emp = new Employess();
        emp.inputData(sc,departmentService);
        if (employeesService.addEmployee(emp)) {
            System.out.println("Thêm nhân viên thành công.");
        } else {
            System.out.println("Thêm nhân viên thất bại.");
        }
    }

    private void updateEmployee(Scanner sc) {
        System.out.print("Nhập mã nhân viên (ID) cần cập nhật: ");
        String id = EmployessValidator.validateId(sc, "(E)\\w{4}");
        Employess emp = employeesService.getEmployeeById(id);

        if (emp == null) {
            System.out.println("Không tìm thấy nhân viên với ID: " + id);
            return;
        }

        int choice;
        do {
            System.out.println("\n===== Cập nhật thông tin nhân viên =====");
            System.out.println("1. Tên: " + emp.getNameEmployess());
            System.out.println("2. Email: " + emp.getEmailEmployess());
            System.out.println("3. Số điện thoại: " + emp.getPhoneEmployess());
            System.out.println("4. Giới tính: " + emp.getSex());
            System.out.println("5. Cấp bậc: " + emp.getLevelEmployess());
            System.out.println("6. Lương: " + emp.getSalaryEmployess());
            System.out.println("7. Ngày sinh: " + emp.getBirthdayEmployess());
            System.out.println("8. Địa chỉ: " + emp.getAddressEmployess());
            System.out.println("9. Trạng thái: " + emp.getStatusEmployess());
            System.out.println("0. Lưu và thoát");
            System.out.print("Chọn mục cần sửa: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    emp.setNameEmployess(Validator.validateString(sc,"vui lòng nhập tên nhân viên",new StringRule(150,15)));
                    break;
                case 2:
                    System.out.print("Nhập email mới: ");
                    emp.setEmailEmployess(EmployessValidator.validateEmail(sc,"vui lòng nhập email"));
                    break;
                case 3:
                    System.out.print("Nhập số điện thoại mới: ");
                    emp.setPhoneEmployess(EmployessValidator.validatePhone(sc,"vui lòng nhập số điện thoạt"));
                    break;
                case 4:
                    System.out.print("Nhập giới tính mới (MALE/FEMALE/OTHER): ");
                    emp.setSex(Validator.validateStatus(sc,"vui lòng nhập giới tính", Sex.class));
                    break;
                case 5:
                    System.out.print("Nhập cấp bậc mới: ");
                    emp.setLevelEmployess(Integer.parseInt(sc.nextLine()));
                    break;
                case 6:
                    System.out.print("Nhập lương mới: ");
                    emp.setSalaryEmployess(Double.parseDouble(sc.nextLine()));
                    break;
                case 7:
                    System.out.print("Nhập ngày sinh mới (yyyy-MM-dd): ");
                    emp.setBirthdayEmployess(EmployessValidator.validateDate("vui lòng nhập ngày sinh ",sc));
                    break;
                case 8:
                    System.out.print("Nhập địa chỉ mới: ");
                    emp.setAddressEmployess(Validator.validateString(sc,"vui lòng nhập đại chỉ ",new StringRule(255,0)));
                    break;
                case 9:
                    System.out.print("Nhập trạng thái mới (ACTIVE/INACTIVE/ONLEAVE/POLICYLEAVE): ");
                    emp.setStatusEmployess(Validator.validateStatus(sc,"vui lòng nhập trạng thái của nhân viên ", StatusEmployess.class));
                    break;
                case 0:
                    boolean result = employeesService.updateEmployee(emp);
                    if (result) {
                        System.out.println("Cập nhật thông tin nhân viên thành công!");
                    } else {
                        System.out.println("Cập nhật thất bại!");
                    }
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
    }


    private void deleteEmployee(Scanner sc) {
        System.out.print("Nhập mã nhân viên (ID) cần cập nhật: ");
        String id = EmployessValidator.validateId(sc, "(E)\\w{4}");
        Employess emp = employeesService.getEmployeeById(id);
        if (emp != null) {
            if (employeesService.deleteEmployee(id)) {
                System.out.println("Đã chuyển trạng thái nhân viên sang INACTIVE.");
            } else {
                System.out.println("Xóa thất bại.");
            }
        }
    }

    private void searchByAge(Scanner sc) {
        System.out.print("Nhập độ tuổi tối thiểu: ");
        int min = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập độ tuổi tối đa: ");
        int max = Integer.parseInt(sc.nextLine());
        List<Employess> list = employeesService.searchByAge( min, max);
        if (list.isEmpty()) {
            System.out.println("Không tìm thấy nhân viên nào trong khoảng tuổi.");
        } else {
            list.forEach(System.out::println);
        }
    }

    private void sortBySalary() {
        List<Employess> list = employeesService.sortBySalaryDesc();
        list.forEach(System.out::println);
    }

    private void sortByName() {
        List<Employess> list = employeesService.sortByNameAsc();
        list.forEach(System.out::println);
    }
}

