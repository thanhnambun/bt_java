package business;

import entity.ClassRoom;
import entity.Schedule;
import entity.Student;
import validate.ValueDator;

import java.util.*;

import static business.StudentBussiness.studentList;

public class ClassRoomBussiness {
    public static final List<ClassRoom> classRoomList = new ArrayList<>();
    public static void sortClassByCreatedDate() {
        classRoomList.stream()
                .sorted(Comparator.comparing(ClassRoom::getCreated).reversed())
                .forEach(System.out::println);
    }
    public static void addClassRoom(Scanner sc) {
        ClassRoom classRoom = new ClassRoom();
        classRoom.inputData(sc);
        classRoomList.add(classRoom);
    }

    public static Optional<ClassRoom> findClassRoomById(Scanner sc) {
        int id = ValueDator.validateInteger(sc, "Vui lòng nhập ID lớp học: ", 1);
        return classRoomList.stream()
                .filter(c -> c.getClassRoomId() == id)
                .findFirst();
    }
    public static void updateClassRoom(Scanner sc) {
        Optional<ClassRoom> crOpt = findClassRoomById(sc);
        if (crOpt.isEmpty()) return;

        ClassRoom cr = crOpt.get();
        if (cr.getStatus() == ClassRoom.Status.CLOSE) {
            System.out.println("Không thể cập nhật lớp học đã đóng.");
            return;
        }

        System.out.println("Nhập lại thông tin lớp:");
        cr.inputData(sc);
        System.out.println("Cập nhật lớp học thành công.");
    }

    public static void deleteClassRoom(Scanner sc) {
        Optional<ClassRoom> crOpt = findClassRoomById(sc);
        if (crOpt.isEmpty()) return;

        ClassRoom cr = crOpt.get();
        if (cr.getTeacherId() != -1 || (cr.getListStudents() != null && !cr.getListStudents().isEmpty())) {
            System.out.println("Không thể xóa lớp vì đã có giáo viên hoặc sinh viên.");
            return;
        }

        classRoomList.remove(cr);
        System.out.println("Xóa lớp học thành công.");
    }

    public static void assignTeacherToClass(Scanner sc) {
        Optional<ClassRoom> crOpt = findClassRoomById(sc);
        if (crOpt.isEmpty()) return;

        ClassRoom cr = crOpt.get();
        System.out.println("vui lòng nhập id của giáo viên ");
        int teacherId = cr.inputTeacherId(sc);
        cr.setTeacherId(teacherId);
        System.out.println("Phân công giáo viên thành công.");
    }
    public static void addStudentToClass(Scanner sc) {
        Optional<ClassRoom> crOpt = findClassRoomById(sc);
        if (crOpt.isEmpty()) return;

        ClassRoom cr = crOpt.get();

        String studentId = ValueDator.validateId(sc, "(SV)\\w{3}", studentList);
        Optional<Student> studentOpt = studentList.stream()
                .filter(s -> s.getStudentId().equals(studentId))
                .findFirst();

        if (studentOpt.isPresent()) {
            cr.getListStudents().add(studentOpt.get());
            System.out.println("Thêm sinh viên vào lớp thành công.");
        } else {
            System.out.println("Không tìm thấy sinh viên.");
        }
    }

    public static void ScheduleClassRoom(Scanner sc) {
        Schedule schedule = new Schedule();
        schedule.inputData(sc);
    }

    public static void updateClassStatus(Scanner sc) {
        Optional<ClassRoom> crOpt = findClassRoomById(sc);
        if (crOpt.isEmpty()) return;

        ClassRoom cr = crOpt.get();
        switch (cr.getStatus()) {
            case PENDING:
                cr.setStatus(ClassRoom.Status.PROGESS);
                System.out.println("Chuyển sang trạng thái PROGESS.");
                break;
            case PROGESS:
                cr.setStatus(ClassRoom.Status.CLOSE);
                System.out.println("Chuyển sang trạng thái CLOSE.");
                break;
            case CLOSE:
                System.out.println("Lớp đã ở trạng thái CLOSE, không thể cập nhật.");
                break;
        }
    }


}
