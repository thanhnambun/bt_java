package entity;

import org.w3c.dom.ls.LSOutput;
import validate.StringRule;
import validate.ValueDator;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

import static business.CourseBussiness.courseList;
import static business.StudentBussiness.studentList;

public class CourseRegistration implements IApp {
    public static int courseRegistrationIdSequen=0;
    private int crid;
    private String studentid;
    private String courseId;
    private LocalDate date;
    private Enum status;
    public enum Enum{
        PENDING, ENROLLED, DROPPED
    }

    public CourseRegistration() {
        this.crid=++courseRegistrationIdSequen;
    }

    public CourseRegistration( String studentid, String courseId, LocalDate date) {
        this.crid = ++courseRegistrationIdSequen;
        this.studentid = studentid;
        this.courseId = courseId;
        this.date = date;
    }


    public int getCrid() {
        return crid;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public LocalDate getDate() {
        return date;
    }
    public Enum getStatus() {
        return status;
    }

    public void setStatus(Enum status) {
        this.status = status;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    @Override
    public void inputData(Scanner sc) {
        this.crid = ++courseRegistrationIdSequen;
        this.studentid = inputSudentId(sc);
        this.courseId =ValueDator.validateId(sc,"(C)w\\4",courseList);
        this.date = ValueDator.validateDate("Vui lòng nhập ngày đăng ký: ", sc);
        this.status = selectStatus(sc);
    }

    private Enum selectStatus(Scanner sc) {
        System.out.println("Chọn trạng thái đăng ký:");
        for (int i = 0; i < Enum.values().length; i++) {
            System.out.println((i + 1) + ". " + Enum.values()[i]);
        }

        while (true) {
            System.out.print("Nhập số tương ứng với trạng thái: ");
            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice >= 1 && choice <= Enum.values().length) {
                    return Enum.values()[choice - 1];
                } else {
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số hợp lệ.");
            }
        }
    }

    public String inputSudentId(Scanner sc) {
        studentList.forEach(System.out::println);
        while(true){
            String studentId = ValueDator.validateString(sc,new StringRule(255,0),"vui lòng nhập id của sinh viên ");
            Optional<Student> studentGetID =  studentList.stream().filter(s->s.getStudentId().equals(studentId)).findFirst();
            if(studentGetID.isPresent()){
                return studentGetID.get().getStudentId();
            }else{
                System.out.println("không có sinh viên với mã sinh viên  "+studentId);
            }
        }
    }

    @Override
    public String toString() {
        return "CourseRegistration{" +
                "crid=" + crid +
                ", studentid='" + studentid + '\'' +
                ", courseId='" + courseId + '\'' +
                ", date=" + date +
                ", status=" + status +
                '}';
    }
}
