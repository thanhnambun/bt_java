import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Bt8  implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private double price;
    public Bt8(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void display() {
        System.out.printf("ID: %d | Name: %s | Price: %.2f VND\n", id, name, price);
    }

    public static void main(String[] args) {
        String fileName = "products.dat";
        List<Bt8> productList = new ArrayList<>();
        productList.add(new Bt8(1, "Laptop", 15000000));
        productList.add(new Bt8(2, "Điện thoại", 8000000));
        productList.add(new Bt8(3, "Tai nghe", 500000));
        try(ObjectOutputStream  writer = new ObjectOutputStream(new FileOutputStream(fileName)))
        {
                writer.writeObject(productList);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            List<Bt8> readList = (List<Bt8>) ois.readObject();
            System.out.println("Đã đọc :");
            for (Bt8 product : readList) {
                product.display();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Lỗi : " + e.getMessage());
        }
    }
}
