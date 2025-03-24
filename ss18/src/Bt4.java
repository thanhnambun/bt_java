import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Bt4 {
    public static void main(String[] args) {
        Map<String, Double> imployee = new TreeMap<>();
        imployee.put("nv123", 50.0);
        imployee.put("nv1", 10.0);
        imployee.put("nv2", 20.0);
        imployee.put("nv4", 30.0);
        imployee.put("nv5", 40.0);
        System.out.println(imployee);
        imployee.put("nv123", 100.0);
        imployee.remove("nv123");
        System.out.println(imployee);
    }
}
