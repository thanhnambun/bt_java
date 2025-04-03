package business;

import entity.Person;
import entity.Teacher;
import validate.PersonValidate;
import validate.StringRule;
import validate.ValueDator;

import java.util.*;

import static business.ClassRoomBussiness.classRoomList;

public class TeachBussiness {
    public static final List<Teacher> teacherList = new ArrayList<>();
    public static void sortTeacherList() {
        teacherList.stream().sorted(Comparator.comparing(Teacher::getTeacherId).reversed()).forEach(System.out::println);
    }
    public static void addTeacher(Scanner sc) {
        Teacher teacher = new Teacher();
        teacher.inputData(sc);
        teacherList.add(teacher);
    }


    public static Optional<Teacher> findTeacherById(int id) {
        return teacherList.stream().filter(t -> t.getTeacherId()==id).findFirst();
    }

    public static void updateTeacher(Scanner sc) {
        int id = ValueDator.validateInteger(sc, "Nhập ID giảng viên cần cập nhật:", 1);
        Optional<Teacher> teacherOpt = findTeacherById(id);

        if (teacherOpt.isPresent()) {
            Teacher teacher = teacherOpt.get();
            System.out.println("1. Sửa tên");
            System.out.println("2. Sửa tuổi");
            System.out.println("3. Sửa địa chỉ");
            System.out.println("4. Sửa số điện thoại");
            System.out.println("5. Sửa email");
            System.out.println("6. Sửa giới tính");
            System.out.println("7. Sửa chuyên môn");
            System.out.println("Chọn thông tin cần sửa:");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> teacher.setPersonName(ValueDator.validateString(sc,new StringRule(150,0),"vui loòng nhập tên giảng viên"));
                case 2 -> teacher.setPersonAge(ValueDator.validateInteger(sc, "Nhập tuổi mới (>=18):", 18));
                case 3 -> teacher.setPersonAddress(ValueDator.validateString(sc,new StringRule(150,0),"vui loòng nhập địa chỉ giảng viên"));
                case 4 -> teacher.setPersonPhone(PersonValidate.validatePhone(sc));
                case 5 -> teacher.setPersonEmail(PersonValidate.validateEmail(sc));
                case 6 -> {
                    System.out.println("Chọn giới tính (1. MALE, 2. FEMALE, 3. OTHER):");
                    int choice1;
                    do {
                        choice1 = sc.nextInt();
                        sc.nextLine();
                        switch (choice1) {
                            case 1:
                                teacher.setGender(Person.Sex.MALE);
                                break;
                            case 2:
                                teacher.setGender(Person.Sex.FEMALE);
                                break;
                            case 3:
                                teacher.setGender(Person.Sex.OTHER);
                                break;
                            default:
                                System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại.");
                        }
                    } while (choice < 1 || choice > 3);
                }
                case 7 -> teacher.setSubject(ValueDator.validateString(sc,new StringRule(150,0),"vui loòng nhập môn giảng dạy"));
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
            System.out.println("Cập nhật thành công!");
        } else {
            System.out.println("Không tìm thấy giảng viên với ID " + id);
        }
    }


    public static void deleteTeacher(Scanner sc) {
        int id = ValueDator.validateInteger(sc, "Nhập ID giảng viên cần cập nhật:", 1);
        Optional<Teacher> teacher = findTeacherById(id);
        if (teacher.isPresent()) {
            boolean isAssigned = classRoomList.stream()
                    .anyMatch(c -> c.getTeacherId()==id);
            if (isAssigned) {
                System.out.println("Không thể xóa, giảng viên đã được xếp lớp!");
            } else {
                teacherList.remove(teacher.get());
                System.out.println("Xóa giảng viên thành công!");
            }
        } else {
            System.out.println("Không tìm thấy giảng viên!");
        }
    }
}
