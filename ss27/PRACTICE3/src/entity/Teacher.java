package entity;

import validate.StringRule;
import validate.ValueDator;

import java.util.Scanner;

public class Teacher extends Person implements IApp {
    private static int teacherIdSequen=0;
    private int teacherId;
    private String subject;

    public Teacher() {
        super();
        this.teacherId=++teacherIdSequen;
    }

    public Teacher( String subject) {
        super();
        this.teacherId = ++teacherIdSequen;
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getTeacherId() {
        return teacherId;
    }

    @Override
    public void inputData(Scanner sc) {
        super.inputData(sc);
        this.teacherId=++teacherIdSequen;
        this.subject= ValueDator.validateString(sc,new StringRule(255,0),"vui lòng nhập môn giảng viên ");
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", subject='" + subject + '\'' +
                '}';
    }
}
