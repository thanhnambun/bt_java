public class bt2 {
    private int id;
    private String name;
    private int department;
    private float salary;

    public bt2(int id, String name, int department, float salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    public void displayInfo() {
        System.out.printf("Mã: %d, Tên: %s, Phòng: %d,\n", id, name, department);
    }
    public float getSalary() {
        return salary;
    }
    public void setSalary(float salary) {
        this.salary = salary;
    }
    public float increaseSalary(double percentage){
        return (float) (salary+((salary*percentage)/100));
    }

    public static void main(String[] args) {
        bt2 nv1 = new bt2(1, "Nguyễn Văn A", 101, 5000);
        nv1.displayInfo();

        nv1.increaseSalary(10);
        nv1.displayInfo();
    }
}
