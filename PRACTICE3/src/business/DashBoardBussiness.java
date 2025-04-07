package business;

import entity.ClassRoom;
import entity.CourseRegistration;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

import static business.StudentBussiness.studentList;
import static business.ClassRoomBussiness.classRoomList;
import static business.TeachBussiness.teacherList;
import static business.CourseRegistrationBussiness.courseRegistrationList;


public class DashBoardBussiness {
    public static void displayStatistics() {
        System.out.println("số lượng sinh viên " + studentList.size());
        System.out.println("số lượng giáo viên " + teacherList.size());
        System.out.println("số lượng lớp học " + classRoomList.size());
        System.out.println("số lượng khóa học " + courseRegistrationList.size());
    }

    public static void maxcourseRegistration() {
        Map<String, Long> courseCountMap = courseRegistrationList.stream()
                .collect(Collectors.groupingBy(CourseRegistration::getCourseId, Collectors.counting()));

        courseCountMap.entrySet().stream()
                .sorted((entry1, entry2) -> Long.compare(entry2.getValue(), entry1.getValue()))
                .limit(3)
                .forEach(e -> {
                    System.out.println(e.getKey() + " " + e.getValue());
                });
    }

    public static void maxcourseClassRoom() {
        classRoomList.stream()
                .sorted(Comparator.comparingInt(classRoom -> classRoom.getListStudents().size())).limit(3).forEach(System.out::println);
    }

    public static void maxcourseTeacher() {
        classRoomList.stream()
                .collect(Collectors.groupingBy(ClassRoom::getTeacherId))
                .entrySet().stream()
                .sorted((entry1, entry2) -> Integer.compare(
                        entry2.getValue().stream().mapToInt(classRoom -> classRoom.getListStudents().size()).sum(),
                        entry1.getValue().stream().mapToInt(classRoom -> classRoom.getListStudents().size()).sum()))
                .limit(3)
                .forEach(entry -> {
                    int teacherId = entry.getKey();
                    int studentCount = entry.getValue().stream()
                            .mapToInt(classRoom -> classRoom.getListStudents().size())
                            .sum();
                    System.out.println("Giảng viên ID: " + teacherId + " - Số sinh viên: " + studentCount);
                });
    }
    public static void maxStudent() {
        Map<String, Long> studentCourseCountMap = courseRegistrationList.stream()
                .collect(Collectors.groupingBy(CourseRegistration::getStudentid, Collectors.counting()));

        studentCourseCountMap.entrySet().stream()
                .sorted((entry1, entry2) -> Long.compare(entry2.getValue(), entry1.getValue()))
                .limit(3)
                .forEach(entry -> {
                    String studentId = entry.getKey();
                    long count = entry.getValue();
                    studentList.stream()
                            .filter(student -> student.getStudentId().equals(studentId))
                            .findFirst()
                            .ifPresent(student -> System.out.println("Sinh viên: " + student.getPersonName() + " - Khóa học: " + count));
                });
    }

}
