package presentation;

import entity.Students;
import java.util.*;

public class StudentManagement {
    public static void main(String[] args) {
        Map<String, Students> studentList = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Quản lý Sinh viên ---");
            System.out.println("1. Danh sách sinh viên");
            System.out.println("2. Thêm sinh viên");
            System.out.println("3. Xóa sinh viên");
            System.out.println("4. Tính điểm trung bình của sinh viên");
            System.out.println("5. In sinh viên có điểm trung bình cao nhất");
            System.out.println("6. In sinh viên có tuổi nhỏ nhất");
            System.out.println("7. Thoát");
            System.out.print("Vui lòng chọn: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    if (!studentList.isEmpty()) {
                        System.out.println("\nDanh sách sinh viên:");
                        for (Students student : studentList.values()) {
                            System.out.println(student);
                        }
                    } else {
                        System.out.println("Chưa có sinh viên nào trong danh sách.");
                    }
                    break;

                case 2:
                    Students student = new Students();
                    student.inputData(sc);
                    studentList.put(student.getId(), student);
                    System.out.println("Đã thêm sinh viên thành công.");
                    break;

                case 3:
                    System.out.print("Nhập ID sinh viên cần xóa: ");
                    String id = sc.next();
                    if (studentList.containsKey(id)) {
                        studentList.remove(id);
                        System.out.println("Xóa sinh viên thành công.");
                    } else {
                        System.out.println("Không tìm thấy sinh viên có ID: " + id);
                    }
                    break;

                case 4:
                    if (studentList.isEmpty()) {
                        System.out.println("Danh sách trống, không thể tính điểm trung bình.");
                    } else {
                        float sum = 0;
                        for (Students s : studentList.values()) {
                            sum += s.getAvgPoin();
                        }
                        System.out.println("Điểm trung bình của tất cả sinh viên: " + (sum / studentList.size()));
                    }
                    break;

                case 5:
                    if (!studentList.isEmpty()) {
                        List<Students> listStudent = new ArrayList<>(studentList.values());
                        listStudent.sort((p1, p2) -> Float.compare(p2.getAvgPoin(), p1.getAvgPoin()));
                        System.out.println("Sinh viên có điểm trung bình cao nhất: ");
                        System.out.println(listStudent.get(0));
                    } else {
                        System.out.println("Danh sách trống.");
                    }
                    break;

                case 6:
                    if (!studentList.isEmpty()) {
                        List<Students> listStudent2 = new ArrayList<>(studentList.values());
                        listStudent2.sort(Comparator.comparingInt(Students::getAge));
                        System.out.println("Sinh viên có tuổi nhỏ nhất: ");
                        System.out.println(listStudent2.get(0));
                    } else {
                        System.out.println("Danh sách trống.");
                    }
                    break;

                case 7:
                    System.out.println("Đã thoát chương trình.");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Vui lòng chọn từ 1 đến 7.");
                    break;
            }
        } while (true);
    }
}
