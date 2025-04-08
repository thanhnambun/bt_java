package presentation;

import business.*;

import java.util.Scanner;


public class UniversityManager {
    private Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        int choice;
        do {
            System.out.println("************************* UNIVERSITY MENU **********************");
            System.out.println("1. Quản lý khóa học");
            System.out.println("2. Quản lý giảng viên");
            System.out.println("3. Quản lý sinh viên");
            System.out.println("4. Đăng ký khóa học");
            System.out.println("5. Quản lý lớp học");
            System.out.println("6. Thống kê");
            System.out.println("7. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    manageCourseMenu();
                    break;
                case 2:
                    manageTeacherMenu();
                    break;
                case 3:
                    manageStudentMenu();
                    break;
                case 4:
                    manageCourseRegistrationMenu();
                    break;
                case 5:
                    manageClassRoomMenu();
                    break;
                case 6:
                    dashboardMenu();
                    break;
                case 7:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
            }
        } while (choice != 7);
    }

    private void manageCourseMenu() {
        int choice;
        do {
            System.out.println("************************* COURSE MENU *************************");
            System.out.println("1. Danh sách khóa học sắp xếp theo tên tăng dần");
            System.out.println("2. Thêm mới khóa học");
            System.out.println("3. Cập nhật khóa học");
            System.out.println("4. Xóa khóa học theo ID");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    CourseBussiness.sortCourse();
                    break;
                case 2:
                    CourseBussiness.addCourse(scanner);
                    break;
                case 3:
                    CourseBussiness.updateCourse(scanner);
                    break;
                case 4:
                    CourseBussiness.deleteCourse(scanner);
                    break;
                case 5:
                    System.out.println("Thoát khóa học menu.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
            }
        } while (choice != 5);
    }

    private void manageTeacherMenu() {
        int choice;
        do {
            System.out.println("************************ TEACHER MENU **************************");
            System.out.println("1. Danh sách giảng viên sắp xếp theo mã giảm dần");
            System.out.println("2. Thêm mới giảng viên");
            System.out.println("3. Cập nhật giảng viên");
            System.out.println("4. Xóa giảng viên");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    TeachBussiness.sortTeacherList();
                    break;
                case 2:
                    TeachBussiness.addTeacher(scanner);
                    break;
                case 3:
                    TeachBussiness.updateTeacher(scanner);
                    break;
                case 4:
                    TeachBussiness.deleteTeacher(scanner);
                    break;
                case 5:
                    System.out.println("Thoát giảng viên menu.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
            }
        } while (choice != 5);
    }

    private void manageStudentMenu() {
        int choice;
        do {
            System.out.println("************************ STUDENT MENU **************************");
            System.out.println("1. Danh sách sinh viên sắp xếp theo tên tăng dần");
            System.out.println("2. Thêm mới sinh viên");
            System.out.println("3. Cập nhật sinh viên");
            System.out.println("4. Xóa sinh viên");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    StudentBussiness.sortStudentList();
                    break;
                case 2:
                    StudentBussiness.addStudent(scanner);
                    break;
                case 3:
                    StudentBussiness.updateStudent(scanner);
                    break;
                case 4:
                    StudentBussiness.deleteStudent(scanner);
                    break;
                case 5:
                    System.out.println("Thoát sinh viên menu.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
            }
        } while (choice != 5);
    }

    private void manageCourseRegistrationMenu() {
        int choice;
        do {
            System.out.println("******************* COURSE REGISTRATION MENU *****************");
            System.out.println("1. Đăng ký khóa học cho sinh viên");
            System.out.println("2. Hủy đăng ký học cho sinh viên");
            System.out.println("3. Duyệt đăng ký học sinh viên");
            System.out.println("4. Xem danh sách sinh viên đăng ký từng khóa học");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    CourseRegistrationBussiness.registerCourse(scanner);
                    break;
                case 2:
                    CourseRegistrationBussiness.cancelStudentRegistration(scanner);
                    break;
                case 3:
                    CourseRegistrationBussiness.approveRegistration(scanner);
                    break;
                case 4:
                    CourseRegistrationBussiness.viewStudentsByCourse(scanner);
                    break;
                case 5:
                    System.out.println("Thoát đăng ký khóa học menu.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
            }
        } while (choice != 5);
    }

    private void manageClassRoomMenu() {
        int choice;
        do {
            System.out.println("********************** CLASS ROOM MENU **********************");
            System.out.println("1. Danh sách lớp học sắp xếp theo ngày tạo giảm dần");
            System.out.println("2. Thêm mới lớp học");
            System.out.println("3. Cập nhật thông tin lớp học");
            System.out.println("4. Xóa lớp học");
            System.out.println("5. Phân công giảng viên cho lớp");
            System.out.println("6. Thêm sinh viên vào lớp");
            System.out.println("7. Tạo lịch học cho lớp");
            System.out.println("8. Cập nhật trạng thái lớp");
            System.out.println("9. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    ClassRoomBussiness.sortClassByCreatedDate();
                    break;
                case 2:
                    ClassRoomBussiness.addClassRoom(scanner);
                    break;
                case 3:
                    ClassRoomBussiness.updateClassRoom(scanner);
                    break;
                case 4:
                    ClassRoomBussiness.deleteClassRoom(scanner);
                    break;
                case 5:
                    ClassRoomBussiness.assignTeacherToClass(scanner);
                    break;
                case 6:
                    ClassRoomBussiness.addStudentToClass(scanner);
                    break;
                case 7:
                    ClassRoomBussiness.ScheduleClassRoom(scanner);
                    break;
                case 8:
                    ClassRoomBussiness.updateClassStatus(scanner);
                    break;
                case 9:
                    System.out.println("Thoát lớp học menu.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
            }
        } while (choice != 9);
    }

    private void dashboardMenu() {
        int choice;
        do {
            System.out.println("************************ DASHBOARD ***************************");
            System.out.println("1. Thống kê số sinh viên, giảng viên, khóa học, lớp học");
            System.out.println("2. Top 3 khóa học có nhiều sinh viên nhất");
            System.out.println("3. Top 3 lớp học có nhiều sinh viên nhất");
            System.out.println("4. Top 3 giảng viên dạy nhiều sinh viên nhất");
            System.out.println("5. Top 3 sinh viên đăng ký học nhiều nhất");
            System.out.println("6. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    DashBoardBussiness.displayStatistics();
                    break;
                case 2:
                    DashBoardBussiness.maxcourseRegistration();
                    break;
                case 3:
                    DashBoardBussiness.maxcourseClassRoom();
                    break;
                case 4:
                    DashBoardBussiness.maxcourseTeacher();
                    break;
                case 5:
                    DashBoardBussiness.maxStudent();
                    break;
                case 6:
                    System.out.println("Thoát thống kê menu.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
            }
        } while (choice != 6);
    }
}
