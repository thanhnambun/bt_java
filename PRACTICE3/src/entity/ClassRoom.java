package entity;

import validate.ClassRoomValidate;
import validate.StringRule;
import validate.ValueDator;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.IntStream;

import static business.CourseBussiness.courseList;
import static business.CourseRegistrationBussiness.courseRegistrationList;
import static business.StudentBussiness.studentList;
import static business.TeachBussiness.teacherList;

public class ClassRoom implements IApp {
    public static final List<Student> stdClassRoomlist = new ArrayList<>();
    private static int classRoomIdSequence = 0;
    private int classRoomId;
    private String classRoomName;
    private String courseId;
    private int teacherId;
    private List<Student> listStudents;
    private LocalDate created;
    private Status status;

    public enum Status {PENDING, PROGESS, CLOSE};

    public ClassRoom() {
        this.classRoomId = ++classRoomIdSequence;
    }

    public ClassRoom(int classRoomId, String classRoomName, String courseId, int teacherId, List<Student> listStudents, LocalDate created, Status status) {
        this.classRoomId = classRoomId;
        this.classRoomName = classRoomName;
        this.courseId = courseId;
        this.teacherId = teacherId;
        this.listStudents = listStudents;
        this.created = created;
        this.status = status;
    }

    public static int getClassRoomIdSequence() {
        return classRoomIdSequence;
    }

    public static void setClassRoomIdSequence(int classRoomIdSequence) {
        ClassRoom.classRoomIdSequence = classRoomIdSequence;
    }

    public int getClassRoomId() {
        return classRoomId;
    }

    public void setClassRoomId(int classRoomId) {
        this.classRoomId = classRoomId;
    }

    public String getClassRoomName() {
        return classRoomName;
    }

    public void setClassRoomName(String classRoomName) {
        this.classRoomName = classRoomName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public List<Student> getListStudents() {
        return listStudents;
    }

    public void setListStudents(List<Student> listStudents) {
        this.listStudents = listStudents;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    @Override
    public void inputData(Scanner sc) {
        this.classRoomId = ++classRoomIdSequence;
        this.classRoomName = ClassRoomValidate.validateClassRoomName(sc);
        this.courseId=inputCourseId(sc);
        this.teacherId = inputTeacherId(sc);
        listStudentClassRoom(this.courseId);
        this.created = ValueDator.validateDate("vui lòng nhập ngày tạo lớp hoc",sc);
        this.status = inputStatus(sc);
    }

    public String inputCourseId(Scanner sc) {
        System.out.println("lựa chon môn học");
        do {
            if (courseList.isEmpty()) {
                return null;
            }
            courseList.forEach(course ->
                    System.out.println(course.getCourseId() + " " + course.getCourseName()));
            String choice = ValueDator.validateString(sc,new StringRule(255,0),"vui lòng nhâ mã môn học ");
            OptionalInt inedex= IntStream.range(0,courseList.size())
                    .filter(index->courseList.get(index).getCourseId().equals(choice)).findFirst();
            if (inedex.isPresent()) {
                return  courseList.get(inedex.getAsInt()).getCourseId();
            }else {
                System.out.println("không có mã môn học đó");
            }
        } while (true);
    }

    public int inputTeacherId (Scanner sc) {
        System.out.println("lựa chọn giáo viên");
        do {
            if(teacherList.isEmpty()){
                return -1 ;
            }
            teacherList.forEach(teacher ->
                    System.out.println("id :" +teacher.getTeacherId() +"môn dạy" +teacher.getSubject()));
            System.out.println("vui lòng chọn");
            int choice = ValueDator.validateInteger(sc,"vui lòng nhập id của giáo viên ",0);
            OptionalInt index = IntStream.range(0,teacherList.size())
                    .filter(x->teacherList.get(x).getTeacherId() ==  choice).findFirst();
            if (index.isPresent()) {
                return teacherList.get(index.getAsInt()).getTeacherId();
            }else{
                System.out.println("không có id của teacher,vui lòng nhập lại");
            }
        }while (true);
    }

    private Status inputStatus(Scanner sc) {
        System.out.println("Chọn trạng thái lớp học:");
        Status[] statuses = Status.values();

        for (int i = 0; i < statuses.length; i++) {
            System.out.println((i + 1) + ". " + statuses[i]);
        }

        while (true) {
            int choice = ValueDator.validateInteger(sc, "Nhập số tương ứng với trạng thái:", 1);
            if (choice >= 1 && choice <= statuses.length) {
                return statuses[choice - 1];
            }
            System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại!");
        }
    }

    public List<Student> listStudentClassRoom(String courseId) {
         courseRegistrationList.stream().filter(course -> course.getCourseId().equals(courseId)).forEach(c->{
           Optional<Student> stdClassRoom= studentList.stream().filter(s->s.getStudentId().equals(c.getCourseId())).findFirst();
            if (stdClassRoom.isPresent()) {
                stdClassRoomlist.add(stdClassRoom.get());
            }
       });
         return  studentList;
    }

    @Override
    public String toString() {
        return "ClassRoom{" +
                "classRoomId=" + classRoomId +
                ", classRoomName='" + classRoomName + '\'' +
                ", courseId='" + courseId + '\'' +
                ", teacherId=" + teacherId +
                ", status=" + status +
                '}';
    }

}
