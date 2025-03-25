package entity;

import java.util.Scanner;

public class Students {
    private String id;
    private String name;
    private int age;
    private float avgPoin;

    public Students(){}

    public Students(String id, String name, int age, float avgPoin) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.avgPoin = avgPoin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getAvgPoin() {
        return avgPoin;
    }

    public void setAvgPoin(float avgPoin) {
        this.avgPoin = avgPoin;
    }

    public void inputData(Scanner sc){
        System.out.println("vui lòng nhập id của sinh viên");
        this.id = sc.nextLine();
        System.out.println("vui lòng nhập tên");
        this.name = sc.nextLine();
        System.out.println("vui lòng nhập tuổi");
        this.age = sc.nextInt();
        System.out.println("nhập điểm trung bình ");
        this.avgPoin = sc.nextFloat();
    }

    @Override
    public String toString() {
        return "Students{" + "id=" + id + ", name=" + name + ", age=" + age + ", avgPoin=" + avgPoin + '}';
    }
}
