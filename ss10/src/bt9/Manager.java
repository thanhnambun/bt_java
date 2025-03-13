package bt9;

public class Manager extends Employee{
     private double bonus;

     public Manager(){}

    public Manager(String name, String id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double getSalary() {
        return salary + bonus;
    }

    @Override
    public String toString() {
        return "Quản lý - Tên: " + name + ", Mã số: " + id + ", Lương cơ bản: " + salary + ", Thưởng: " + bonus;
    }
}
