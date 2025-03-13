package bt9;

public class Main {
    public static void main(String[] args) {
        Employee emp = new Employee("nam", "a", 5000);
        Manager mgr = new Manager("bun", "a2", 2000, 21000);
        Developer dev = new Developer("tiên", "a3", 5678999, "rrrr");

        System.out.println(emp.toString());
        System.out.println("Lương nhân viên: " + emp.getSalary());

        System.out.println(mgr.toString());
        System.out.println("Lương quản lý: " + mgr.getSalary());

        System.out.println(dev.toString());
        System.out.println("Lương dev: " + dev.getSalary());

        System.out.println("Tăng lương cho nhân viên " + emp.name + " thêm 150...");
        emp.increaseSalary(150);
        System.out.println(emp.toString());
        System.out.println("Lương sau tăng: " + emp.getSalary());
    }
}