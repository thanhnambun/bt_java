package entity;

import validate.CourseValidate;
import validate.StringRule;
import validate.ValueDator;

import java.util.Scanner;

import static business.CourseBussiness.courseList;

public class Course implements IApp{
    private String courseId;
    private String courseName;
    private boolean status;

    public Course(){}

    public Course(String courseId, String courseName, boolean status) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.status = status;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner sc) {
        this.courseId= inputID(sc);
        this.courseName= CourseValidate.validateCourseName(sc);
        this.status = ValueDator.validateBoolean(sc,"vui lòng nhập trạng thái của khoas học ");
    }

    public static String inputID(Scanner sc) {
        return ValueDator.validateId(sc,"(C)\\w{4}",courseList);
    }



    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", status=" + status +
                '}';
    }
}
