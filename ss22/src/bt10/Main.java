package bt10;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        manager.addStudent(new Student(101, "nam", "IT", 3.8));
        manager.addStudent(new Student(102, "dương", "Business", 3.5));
        manager.addStudent(new Student(103, "tùng", "IT", 3.9));
        manager.addStudent(new Student(104, "hoàng", "Economics", 2.8));
        manager.addStudent(new Student(105, "Lan", "IT", 3.6));

        System.out.println("\n DANH SÁCH SINH VIÊN BAN ĐẦU ");
        manager.displayAllStudents();

        String filename = "students.dat";
        manager.saveToFile(filename);

        manager = new StudentManager();
        manager.loadFromFile(filename);

        System.out.println("\n DANH SÁCH SAU KHI ĐỌC FILE");
        manager.displayAllStudents();

        Student topStudent = manager.findTopStudent();
        if (topStudent != null) {
            System.out.println("\nSinh viên có GPA cao nhất:");
            System.out.println(topStudent);
        } else {
            System.out.println("\n Không tìm thấy sinh viên nào.");
        }

        String searchMajor = "IT";
        List<Student> itStudents = manager.searchByMajor(searchMajor);
        System.out.println("\nDanh sách sinh viên chuyên ngành " + searchMajor + ":");
        itStudents.forEach(System.out::println);

        double avgGpa = manager.calculateAverageGpa();
        System.out.printf("\nĐiểm trung bình GPA của toàn bộ danh sách: %.2f%n", avgGpa);
    }
}