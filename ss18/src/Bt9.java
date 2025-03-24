import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bt9 {
    private int id;
    private String name;
    private double price;
    private int quantity;

    public Bt9(){}

    public Bt9(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void inputdata(Scanner sc) {
        System.out.println("vui lon nhập tên");
        this.name = sc.next();
        System.out.println("vui lòng nhập giias");
        this.price = sc.nextDouble();
        System.out.println("vui lòng nhập số lượng ");
        this.quantity = sc.nextInt();
    }

    public static void main(String[] args) {
        Map<Integer, Bt9> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int choice;
        int count=0;
        do {
            System.out.println("1.them");
            System.out.println("2.cap nhật");
            System.out.println("3.xóa");
            System.out.println("4.tính tổng");
            System.out.println("5.thoát");
            System.out.println("chọn");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Bt9 add= new Bt9();
                    add.inputdata(sc);
                    map.put(count,add);
                    count++;
                    break;
                case 2:
                    System.out.println("vui lòng nhập id cần cập nhật");
                    int id = sc.nextInt();
                    if (map.containsKey(id)) {
                        Bt9 value = map.get(id);
                        System.out.println("Vui lòng cập nhật giá:");
                        value.setPrice(sc.nextDouble());
                        System.out.println("Vui lòng cập nhật số lượng:");
                        value.setQuantity(sc.nextInt());
                    } else {
                        System.out.println("Không tìm thấy sản phẩm với id: " + id);
                    }
                    break;
                case 3:
                    System.out.println("Vui lòng nhập id cần xóa:");
                    int id1 = sc.nextInt();
                    if (map.containsKey(id1)) {
                        map.remove(id1);
                        System.out.println("Đã xóa sản phẩm có id: " + id1);
                    } else {
                        System.out.println("Không tìm thấy sản phẩm với id: " + id1);
                    }
                    break;
                case 4:
                    double sum = 0 ;
                    for(Map.Entry<Integer,Bt9> entry : map.entrySet()){
                        sum +=(entry.getValue().price* entry.getValue().getQuantity());
                    }
                    System.out.println(sum);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("vui lòng nhập từ 1-5");
                    break;
            }
        } while (true);
    }
}
