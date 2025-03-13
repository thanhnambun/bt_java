package bt9;

public class Employee {
    public String name;
    public String id;
    public double salary;

    public Employee() {
        this.name = "";
        this.id = "";
        this.salary = 0.0;
    }

    public Employee(String name, String id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void increaseSalary(double amount) {
        if (amount > 0) {
            this.salary += amount;
        } else {
            System.out.println("Số tiền tăng lương phải lớn hơn 0.");
        }
    }

    @Override
    public String toString() {
        return "Nhân viên - Tên: " + name + ", Mã số: " + id + ", Lương: " + salary;
    }
}