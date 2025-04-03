package entity;

import validate.ValueDator;

import java.util.Scanner;

import static business.StudentBussiness.studentList;

public class Student extends Person implements IApp  {
    private String studentId;
    private double gpa;

    public Student() {
        super();
    }

    public Student(String studentId, double gpa) {
        super();
        this.studentId = studentId;
        this.gpa = gpa;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public void inputData(Scanner sc) {
        super.inputData(sc);
        this.studentId= ValueDator.validateId(sc,"(SV)w\\{3}",studentList);
        this.gpa = ValueDator.validateDouble(sc,"vui lòng nhập điểm của sinh viên ");
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", gpa=" + gpa +
                '}';
    }
}
