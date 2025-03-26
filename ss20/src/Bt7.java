import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bt7 {
    private String name;
    private int age;
    private String department;
    private Double salary;

    public Bt7() {
    }

    public Bt7(String name, int age, String department, Double salary) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
    @Override
    public String toString() {
        return String.format("Tên: %s, Tuổi: %d, Phòng: %s, Lương: %.2f", name, age, department, salary);
    }

    public static void main(String[] args) {
        List<Bt7> list = List.of(
                new Bt7("Quý", 26, "IT", 2500.0),
                new Bt7("Lan", 24, "IT", 2100.0),
                new Bt7("Minh", 30, "HR", 3000.0),
                new Bt7("Huyền", 28, "IT", 2000.0),
                new Bt7("Long", 32, "IT", 3100.0),
                new Bt7("Trang", 25, "Marketing", 2200.0),
                new Bt7("Việt", 27, "IT", 2500.0)
        );
        list.stream().filter(x ->x.getSalary()>2000&&x.getAge()>25 && x.getDepartment().equals("IT") ).forEach(System.out::println);
        System.out.println("sắp xếp");
        list.stream().sorted(Comparator.comparing(Bt7 ::getSalary).reversed().thenComparing(Bt7::getName)).forEach(System.out::println);
    }
}
