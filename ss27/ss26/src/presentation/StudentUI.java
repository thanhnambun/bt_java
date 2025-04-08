package presentation;

import business.model.Student;
import business.service.student.StudentService;
import business.service.student.StudentServiceImp;

import java.util.List;
import java.util.Scanner;

public class StudentUI {
    private final StudentService studentService;
    public StudentUI() {
            studentService = new StudentServiceImp();
    }
    public static void main(String[] args) {
        StudentUI studentUI = new StudentUI();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("menu");
            System.out.println("1.danh sách");
            System.out.println("2. thêm ");
            System.out.println("3. sửa ");
            System.out.println("4. xóa ");
            System.out.println("5. thống kê trạng thái");
            System.out.println("6. thoát");
            System.out.printf("vui lòng chọn");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    studentUI.displayStudent();
                    break;
                case 2:
                    studentUI.addStudent(sc);
                    break;
                case 3:
                    studentUI.updateStudent(sc);
                    break;
                case 4:
                    studentUI.deleteStudent(sc);
                    break;
                case 5:
                    studentUI.countStudentByStatus(sc);
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("vui lòng chọn 1-6");
                    break;
            }
        } while (true);
    }
    public  void displayStudent(){
        List<Student> listStdent =studentService.findAll();
        listStdent.forEach(System.out::println);
    }
    public void addStudent(Scanner sc){
        System.out.println("nhập số sinh viên cần thêm");
        int i = Integer.parseInt(sc.nextLine());
        for (int j = 0; j < i; j++) {
            Student student = new Student();
            student.inputData(sc);
            Boolean check =studentService.save(student);
            if(check){
                System.out.println("threem mới thành công ");
            }else {
                System.err.println("có lỗi");
            }
        }
    }
    public void updateStudent(Scanner sc){
        System.out.println("vui lòng nập id cần sửa");
        int id = Integer.parseInt(sc.nextLine());
        Student student = studentService.findById(id);
        student.inputData(sc);
        Boolean check =studentService.update(student);
        if(check){
            System.out.println("đã sửa thnafh công");
        }else {
            System.err.println("lỗi");
        }
    }
    public void deleteStudent(Scanner sc){
        System.out.println("vui lòng nhập id cần xóa ");
        int id = Integer.parseInt(sc.nextLine());
        Student stdent = studentService.findById(id);
        Boolean check =studentService.delete(stdent);
        if(check){
            System.out.println("đã xóa thh công");
        }else {
            System.err.println("lỗi");
        }
    }
    public void countStudentByStatus(Scanner sc){
        System.out.println("vui lòng nhập tran ythasi càn thoobgs kê");
        Boolean status = Boolean.parseBoolean(sc.nextLine());
        int count = studentService.getCountStudentByStatus(status);
        System.out.println("thống kê trạng thái " + status + " có " +count);
    }
}
