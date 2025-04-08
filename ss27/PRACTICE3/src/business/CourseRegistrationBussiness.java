package business;

import entity.CourseRegistration;
import entity.Student;
import validate.ValueDator;

import java.util.*;

import static business.CourseBussiness.courseList;
import static business.StudentBussiness.studentList;

public class CourseRegistrationBussiness {
    public static final List<CourseRegistration> courseRegistrationList = new ArrayList<>();

    public static void registerCourse(Scanner sc) {
        CourseRegistration cr = new CourseRegistration();
        cr.inputData(sc);

        boolean alreadyExists = courseRegistrationList.stream()
                .anyMatch(c -> c.getStudentid().equals(cr.getStudentid())
                        && c.getCourseId().equals(cr.getCourseId())
                        && c.getStatus() != CourseRegistration.Enum.PENDING);

        if (alreadyExists) {
            System.out.println("Sinh viên đã đăng ký khóa học này rồi!");
            return;
        }

        courseRegistrationList.add(cr);
        System.out.println("Đăng ký thành công! Trạng thái: PENDING");
    }

    public static void cancelStudentRegistration(Scanner sc) {
        String studentId = ValueDator.validateId(sc, "SV\\d{3}", studentList);
        String courseId = ValueDator.validateId(sc, "KH\\d{3}", courseList);

        Optional<CourseRegistration> crOpt = courseRegistrationList.stream()
                .filter(c -> c.getStudentid().equals(studentId)
                        && c.getCourseId().equals(courseId)
                        && c.getStatus() == CourseRegistration.Enum.PENDING)
                .findFirst();

        if (crOpt.isPresent()) {
            crOpt.get().setStatus(CourseRegistration.Enum.ENROLLED);
            System.out.println("Hủy đăng ký thành công!");
        } else {
            System.out.println("Không thể hủy! Không tìm thấy hoặc trạng thái không phải PENDING.");
        }
    }

    public static void approveRegistration(Scanner sc) {
        String studentId = ValueDator.validateId(sc, "SV\\d{3}", studentList);
        String courseId = ValueDator.validateId(sc, "C\\d{4}", courseList);

        Optional<CourseRegistration> crOpt = courseRegistrationList.stream()
                .filter(c -> c.getStudentid().equals(studentId)
                        && c.getCourseId().equals(courseId)
                        && c.getStatus() == CourseRegistration.Enum.PENDING)
                .findFirst();

        if (crOpt.isPresent()) {
            crOpt.get().setStatus(CourseRegistration.Enum.ENROLLED);
            System.out.println("Duyệt đăng ký thành công!");
        } else {
            System.out.println("Không thể duyệt! Không tìm thấy hoặc trạng thái không phải PENDING.");
        }
    }

    public static void viewStudentsByCourse(Scanner sc) {
        String courseId = ValueDator.validateId(sc, "KH\\d{3}", courseList);
        List<CourseRegistration> list = courseRegistrationList.stream()
                .filter(c -> c.getCourseId().equals(courseId)
                        && c.getStatus() != CourseRegistration.Enum.PENDING)
                .toList();

        if (list.isEmpty()) {
            System.out.println("Không có sinh viên nào đăng ký khóa học này.");
        } else {
            System.out.println("Danh sách sinh viên đăng ký:");
            for (CourseRegistration cr : list) {
                Optional<Student> student = studentList.stream()
                        .filter(s -> s.getStudentId().equals(cr.getStudentid()))
                        .findFirst();
                student.ifPresent(value -> System.out.println("- " + value.getPersonName() + " (ID: " + value.getStudentId() + ") - Trạng thái: " + cr.getStatus()));
            }
        }
    }
}
