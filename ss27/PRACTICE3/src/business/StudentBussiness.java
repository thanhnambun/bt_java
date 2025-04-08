package business;

import entity.Person;
import entity.Student;
import validate.PersonValidate;
import validate.StringRule;
import validate.ValueDator;

import java.util.*;

import static business.ClassRoomBussiness.classRoomList;
import static business.CourseRegistrationBussiness.courseRegistrationList;

public class StudentBussiness {
    public static final List<Student> studentList = new ArrayList<>();

    public static void sortStudentList() {
        studentList.stream()
                .sorted(Comparator.comparing(Student::getPersonName).reversed())
                .forEach(System.out::println);
    }

    public static void addStudent(Scanner sc) {
        Student st = new Student();
        st.inputData(sc);
        studentList.add(st);
    }

    public static Optional<Student> findStudentById(String id) {
        return studentList.stream().filter(t -> t.getStudentId().equals(id)).findFirst();
    }

    public static void updateStudent(Scanner sc) {
        String id = ValueDator.validateId(sc, "(SV)w\\{3}", studentList);
        Optional<Student> studentOpt = findStudentById(id);

        if (studentOpt.isPresent()) {
            Student student = studentOpt.get();
            System.out.println("1. Sửa tên");
            System.out.println("2. Sửa tuổi");
            System.out.println("3. Sửa địa chỉ");
            System.out.println("4. Sửa số điện thoại");
            System.out.println("5. Sửa email");
            System.out.println("6. Sửa giới tính");
            System.out.println("7. Sửa điểm trung bình");
            System.out.print("Chọn thông tin cần sửa: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> student.setPersonName(ValueDator.validateString(sc, new StringRule(150, 0), "Vui lòng nhập tên sinh viên: "));
                case 2 -> student.setPersonAge(ValueDator.validateInteger(sc, "Nhập tuổi mới (>=18):", 18));
                case 3 -> student.setPersonAddress(ValueDator.validateString(sc, new StringRule(150, 0), "Vui lòng nhập địa chỉ sinh viên: "));
                case 4 -> student.setPersonPhone(PersonValidate.validatePhone(sc));
                case 5 -> student.setPersonEmail(PersonValidate.validateEmail(sc));
                case 6 -> {
                    System.out.println("Chọn giới tính (1. MALE, 2. FEMALE, 3. OTHER):");
                    int choice1;
                    do {
                        choice1 = sc.nextInt();
                        sc.nextLine();
                        switch (choice1) {
                            case 1 -> student.setGender(Person.Sex.MALE);
                            case 2 -> student.setGender(Person.Sex.FEMALE);
                            case 3 -> student.setGender(Person.Sex.OTHER);
                            default -> System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại.");
                        }
                    } while (choice1 < 1 || choice1 > 3);
                }
                case 7 -> student.setGpa(ValueDator.validateDouble(sc, "Vui lòng nhập điểm của sinh viên: "));
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
            System.out.println("Cập nhật thành công!");
        } else {
            System.out.println("Không tìm thấy sinh viên với ID " + id);
        }
    }

    public static void deleteStudent(Scanner sc) {
        String id = ValueDator.validateId(sc, "(SV)w\\{3}", studentList);
        Optional<Student> studentOpt = findStudentById(id);
        if (studentOpt.isPresent()) {
            boolean isAssigned = courseRegistrationList.stream().anyMatch(c -> c.getStudentid().equals(studentOpt.get().getStudentId()));
            if (isAssigned) {
                System.out.println("Không thể xóa, sinh viên đã được xếp lớp!");
            } else {
                studentList.remove(studentOpt.get());
                System.out.println("Xóa sinh viên thành công!");
            }
        } else {
            System.out.println("Không tìm thấy sinh viên!");
        }
    }
}
