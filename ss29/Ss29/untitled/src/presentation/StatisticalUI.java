package presentation;

import business.model.Department;
import business.service.department.DepartmentService;
import business.service.department.DerpartmentServiceImp;
import business.service.statistical.StatisticalService;
import business.service.statistical.StatisticalServiceImp;
import validate.Validator;

import java.util.Scanner;

public class StatisticalUI {
    private final StatisticalService statisticalService;
    public StatisticalUI() {
        statisticalService = new StatisticalServiceImp();
    }
    public static void displayMenu(Scanner sc) {
        StatisticalUI statistical = new StatisticalUI();
        DepartmentService departmentService = new DerpartmentServiceImp();
        int choice;
        do {
            System.out.println(" MENU Thống Kê ");
            System.out.println("1. Số lượng nhân viên theo từng phòng ban");
            System.out.println("2. Tổng số nhân viên của toàn bộ hệ thống");
            System.out.println("3. Phòng ban có nhiều nhân viên nhất");
            System.out.println("4. Phòng ban có lương cao nhất");
            System.out.println("5. Thoát");
            choice = Validator.validateChoice(sc);
            switch (choice) {
                case 1:
                    statistical.epmlByDepartment();
                    break;
                case 2:
                    statistical.sum_empl(departmentService);
                    break;
                case 3:
                    statistical.department_max_empl(departmentService);
                    break;
                case 4:
                    statistical.sum_max_salary(departmentService);
                    break;
                case 5:
                    System.out.println("Đã thó menu thống kê ");
                    System.exit(0);
                    break;
                default:
                    System.out.println("vui lòng nhập từ 1 - 5");
                    break;
            }
        } while (true);
    }
    public void epmlByDepartment() {
        statisticalService.goupbyDepartment();
    }
    public void sum_empl(DepartmentService departmentService) {
        int idDepartment = statisticalService.sum_empl();
        Department dept= departmentService.getById(idDepartment);
        System.out.println(dept);
    }
    public void department_max_empl(DepartmentService departmentService) {
        int idDepartment = statisticalService.department_max_empl();
        Department dept= departmentService.getById(idDepartment);
        System.out.println(dept);
    }
    public void sum_max_salary(DepartmentService departmentService) {
        int idDepartment = statisticalService.sum_max_salary();
        Department dept= departmentService.getById(idDepartment);
        System.out.println(dept);
    }
}
