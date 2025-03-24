import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bt10 {
    private int id;
    private String name;
    private float salary;

    public Bt10() {
    }

    public Bt10(String name, float salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void inputdata(Scanner sc){
        System.out.println("vui long nhập ten nv");
        this.name = sc.next();
        System.out.println("nhập lương");
        this.salary = sc.nextFloat();
    }

    public static void main(String[] args) {
        Map<Integer, Bt10> imployee = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int choice;
        int count =0 ;
        int sum = 0;
        do {
            System.out.println("1. thêm ");
            System.out.println("2. hien thi");
            System.out.println("3. tính tổng lương");
            System.out.println("4. tính trung bình lương");
            System.out.println("5.tìm lương cao nhất ");
            System.out.println("6.tim luowg thấp nhất");
            System.out.println("7.thoát");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Bt10 bt10 = new Bt10();
                    bt10.inputdata(sc);
                    imployee.put(count, bt10);
                    count++;
                    break;
                case 2:
                    System.out.println(imployee);
                    break;
                case 3:
                    for (Map.Entry<Integer, Bt10> entry : imployee.entrySet()) {
                        sum += entry.getValue().getSalary();
                    }
                    System.out.println(sum);
                    break;
                case 4:
                    System.out.println("lương trung bình " +sum/ imployee.size() );
                    break;
                case 5:
                    float max =imployee.get(0).salary;
                    for (Map.Entry<Integer, Bt10> entry : imployee.entrySet()) {
                        if (entry.getValue().getSalary() > max) {
                            max = entry.getValue().getSalary();
                        }
                    }
                    System.out.println(max);
                    break;
                case 6:
                    float min =imployee.get(0).salary;
                    for (Map.Entry<Integer, Bt10> entry : imployee.entrySet()) {
                        if (entry.getValue().getSalary() < min) {
                            min = entry.getValue().getSalary();
                        }
                    }
                    System.out.println(min);
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("vui lòng nhập từ 1-7");
                    break;
            }
        } while (true);
    }
}
