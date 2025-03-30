package bt10;

import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String major;
    private double gpa;

    public Student() {
    }
    public Student(int id, String name, String major, double gpa) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Tên: %-10s | Chuyên ngành: %-10s | GPA: %.2f", id, name, major, gpa);
    }
}