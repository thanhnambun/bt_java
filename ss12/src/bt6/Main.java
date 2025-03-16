package bt6;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[3];

        employees[0] = new FullTimeEmployee("Alice", 30, 3000, 500);
        employees[1] = new PartTimeEmployee("Bob", 22, 20, 80); // 20$/h * 80h
        employees[2] = new Intern("Charlie", 20, 1000);

        for (Employee emp : employees) {
            emp.showInfo();
        }
    }
}

