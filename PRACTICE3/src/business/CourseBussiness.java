package business;

import entity.ClassRoom;
import entity.Course;
import validate.CourseValidate;
import validate.StringRule;
import validate.ValueDator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static business.ClassRoomBussiness.classRoomList;

public class CourseBussiness {
    public static final List<Course> courseList = new ArrayList<>();

    public static void sortCourse() {
        courseList.stream().sorted().forEach(System.out::println);
    }

    public static void addCourse(Scanner sc) {
        Course course = new Course();
        course.inputData(sc);
        courseList.add(course);
    }

    public static Optional<Course> findCourseId(String id) {
        return courseList.stream().filter(c -> c.getCourseId().equals(id)).findFirst();
    }

    public static void updateCourse(Scanner sc) {
        String id = ValueDator.validateString(sc, new StringRule(5, 0), "vui lòng nhập id của khóa học cần cập nhật");
        Optional<Course> course = findCourseId(id);
        if (course.isPresent()) {
            Course course1 = course.get();
            System.out.println("1. Sửa tên khóa học");
            System.out.println("2. sửa trạng thái ");
            int choice = sc.nextInt();
            if (choice == 1) {
                String newCourseName = CourseValidate.validateCourseName(sc);
                course1.setCourseName(newCourseName);
            } else if (choice == 2) {
                boolean newStatus = ValueDator.validateBoolean(sc, "vui lòng nhập trạng thái của khoas học ");
                course1.setStatus(newStatus);
            } else {
                System.out.println("vui lòng nhập 1 và 2 ");
            }
        }
    }

    public static void deleteCourse(Scanner sc) {
        String id = ValueDator.validateString(sc, new StringRule(5, 0), "vui lòng nhập id của khóa học cần cập nhật");
        Optional<Course> course = findCourseId(id);
        if (course.isPresent()) {
            Course course1 = course.get();
            Optional<ClassRoom> check = classRoomList.stream().filter(c -> c.getCourseId().equals(course1.getCourseId())).findFirst();
            if (check.isPresent()) {
                System.out.println("không thể xóa môn học ,vì đã có lớp học môn này ");
            } else {
                courseList.remove(course1);
            }
        }
    }

}
