package bt7;

public class Student {
    private String name;
    private String id;
    private double gpa;

    public Student(double gpa, String id, String name) {
        this.gpa = gpa;
        this.id = id;
        this.name = name;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            System.out.println("lỗi");
        } else {
            this.name = name;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null) {
            System.out.println("lỗi");
        } else {
            this.id = id;
        }
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        if (gpa < 0) {
            System.out.println("lỗi");
        } else {
            this.gpa = gpa;
        }
    }

    public void getDetails() {
        System.out.println("thông tin chi tiết của sinh viên là");
        System.out.println("tên " + this.name);
        System.out.println("mã sinh viên " + this.id);
        System.out.println("điểm trung bình " + this.gpa);
    }
}
