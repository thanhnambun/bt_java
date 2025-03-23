package business;

import entity.Student;
import presentation.StudentApplication;
import validate.Validator;

import java.util.Scanner;

public class StudentBusiness {
    public static void showStudent(Scanner scanner) {
        if (StudentApplication.sudentIndex == 0) {
            System.out.println("Danh sách sinh viên trống.");
            return;
        }

        System.out.println("----- DANH SÁCH SINH VIÊN -----");
        for (int i = 0; i < StudentApplication.sudentIndex; i++) {
            StudentApplication.studentList[i].displayData();
        }
    }

    public static void addStudent(Scanner scanner) {
        for (int i = 0; i < StudentApplication.sudentIndex; i++) {
            StudentApplication.studentList[StudentApplication.sudentIndex] = new Student();
            StudentApplication.studentList[StudentApplication.sudentIndex].displayData();
            StudentApplication.sudentIndex++;
        }
    }

    public static void updateStudent(Scanner scanner) {
        System.out.println("vui lòng nhập id");
        int choice;
        String studentId = scanner.nextLine();
        int index = findStudent(studentId);
        if (index == -1) {
            System.out.println("không tìm thấy id cần chỉnh sửa ");
        }
        StudentApplication.studentList[index].displayData();
        Student std = new Student();
        do {
            System.out.println("1. sửa tên ");
            System.out.println("2. sửa ngày sinh");
            System.out.println("3. sửa số điện thoại ");
            System.out.println("4. sửa giới tính ");
            System.out.println("5. sửa email ");
            System.out.println("6. sửa ngành học ");
            System.out.println("7. sửa lớp ");
            System.out.println("8. sửa điểm");
            System.out.println("9.sửa trạng thái ");
            System.out.println("10. thoát");
            System.out.println("vui lòng chọn ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    std.inputStudentName(scanner);
                    break;
                case 2:
                    std.inputBirthday(scanner);
                    break;
                case 3:
                    std.inputPhone(scanner);
                    break;
                case 4:
                    std.inputSex(scanner);
                    break;
                case 5:
                    std.inputEmail(scanner);
                    break;
                case 6:
                    std.inputMajor(scanner);
                    break;
                case 7:
                    std.inputClassName(scanner);
                    break;
                case 8:
                    std.inputGpa(scanner);
                    break;
                case 9:
                    std.inputStatus(scanner);
                    break;
                case 10:
                    System.out.println("đã thoát chỉnh sửa.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("vui lòng chọn từ 1 - 10");
                    break;
            }
        } while (true);

    }

    public static int findStudent(String studentId) {
        for (int i = 0; i < StudentApplication.sudentIndex; i++) {
            if (StudentApplication.studentList[i].getStudentId().equals(studentId)) {
                return i;
            }
        }
        return -1;
    }

    public static void deleteStudent(Scanner scanner) {
        System.out.print("Nhập mã sinh viên cần xóa: ");
        String studentId = scanner.nextLine();
        int index = findStudent(studentId);

        if (index == -1) {
            System.err.println("Không tìm thấy sinh viên có mã: " + studentId);
            return;
        }

        System.out.println("Thông tin sinh viên cần xóa:");
        StudentApplication.studentList[index].displayData();
        System.out.print("Bạn có chắc muốn xóa sinh viên này không? (Y/N): ");
        String confirm = scanner.nextLine().trim();

        if (confirm.equalsIgnoreCase("Y")) {
            for (int i = index; i < StudentApplication.sudentIndex - 1; i++) {
                StudentApplication.studentList[i] = StudentApplication.studentList[i + 1];
            }
            StudentApplication.studentList[--StudentApplication.sudentIndex] = null;
            System.out.println("Xóa sinh viên thành công.");
        } else {
            System.out.println("Hủy thao tác xóa.");
        }
    }

    public static void searchStudent(Scanner scanner) {
        int choice;
        do {
            System.out.println("1. tìm kiếm theo tên sinh viên ");
            System.out.println("2. tìm kiếm theo lớp học ");
            System.out.println("3. tìm kiếm theo khoảng điểm ");
            System.out.println("4. thoát");
            System.out.println("vui lòng chọn ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    searchStudentByNameOrClass(scanner);
                    break;
                case 2:
                    searchStudentByNameOrClass(scanner);
                    break;
                case 3:
                    searchStudentByPoin(scanner);
                    break;
                case 4:
                    System.out.println("đã thoát chung trình ");
                    System.exit(0);
                    break;
                default:
                    System.out.println("vui lòng chọn từ 1-4");
                    break;
            }
        } while (true);
    }

    public static void searchStudentByNameOrClass(Scanner scanner){
        System.out.println("vui lòng nhập  ");
        String studentSearch = scanner.nextLine();
        boolean check = false;
        for (int i = 0; i < StudentApplication.sudentIndex; i++) {
            if (StudentApplication.studentList[i].getStudentName().equals(studentSearch) ||StudentApplication.studentList[i].getClassName().equals(studentSearch)) {
                StudentApplication.studentList[i].displayData();
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println("không tìm thaasy sinh viên");
        }
    }

    public static void searchStudentByPoin(Scanner scanner) {
        System.out.println("vui lòng nhập điểm (min,max)");
        double min  = Double.parseDouble(scanner.nextLine());
        double max  = Double.parseDouble(scanner.nextLine());
        for (int i = 0; i < StudentApplication.sudentIndex; i++) {
            if (StudentApplication.studentList[i].getGpa() >= min && StudentApplication.studentList[i].getGpa() <= max) {
                StudentApplication.studentList[i].displayData();
            }
        }

    }

    public static void sortStudent(Scanner scanner) {
        System.out.println("\n--- Sắp xếp sinh viên theo ---");
        System.out.println("1. Tên tăng dần");
        System.out.println("2. Tên giảm dần");
        System.out.println("3. GPA tăng dần");
        System.out.println("4. GPA giảm dần");
        System.out.print("Chọn: ");
        String choice = scanner.nextLine();

        boolean swapped;
        switch (choice) {
            case "1":
                for (int i = 0; i < StudentApplication.sudentIndex - 1; i++) {
                    for (int j = 0; j < StudentApplication.sudentIndex - i - 1; j++) {
                        if (StudentApplication.studentList[j].getStudentName()
                                .compareToIgnoreCase(StudentApplication.studentList[j + 1].getStudentName()) > 0) {
                            swap(j, j + 1);
                        }
                    }
                }
                System.out.println("Đã sắp xếp theo tên tăng dần.");
                break;
            case "2":
                for (int i = 0; i < StudentApplication.sudentIndex - 1; i++) {
                    for (int j = 0; j < StudentApplication.sudentIndex - i - 1; j++) {
                        if (StudentApplication.studentList[j].getStudentName()
                                .compareToIgnoreCase(StudentApplication.studentList[j + 1].getStudentName()) < 0) {
                            swap(j, j + 1);
                        }
                    }
                }
                System.out.println("Đã sắp xếp theo tên giảm dần.");
                break;
            case "3":
                for (int i = 0; i < StudentApplication.sudentIndex - 1; i++) {
                    for (int j = 0; j < StudentApplication.sudentIndex - i - 1; j++) {
                        if (StudentApplication.studentList[j].getGpa() > StudentApplication.studentList[j + 1].getGpa()) {
                            swap(j, j + 1);
                        }
                    }
                }
                System.out.println("Đã sắp xếp theo GPA tăng dần.");
                break;
            case "4":
                for (int i = 0; i < StudentApplication.sudentIndex - 1; i++) {
                    for (int j = 0; j < StudentApplication.sudentIndex - i - 1; j++) {
                        if (StudentApplication.studentList[j].getGpa() < StudentApplication.studentList[j + 1].getGpa()) {
                            swap(j, j + 1);
                        }
                    }
                }
                System.out.println("Đã sắp xếp theo GPA giảm dần.");
                break;
            default:
                System.err.println("Lựa chọn không hợp lệ.");
        }

        showStudent(scanner);
    }

    private static void swap(int i, int j) {
        Student temp = StudentApplication.studentList[i];
        StudentApplication.studentList[i] = StudentApplication.studentList[j];
        StudentApplication.studentList[j] = temp;
    }

}