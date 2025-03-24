import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bt8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"I");
        map.put(2,"II");
        map.put(3,"III");
        map.put(4,"IV");
        map.put(5,"V");
        map.put(6,"VI");
        map.put(7,"VII");
        map.put(8,"VIII");
        map.put(9,"IX");
        map.put(10,"X");
        System.out.println("vui lon nhập số nguyên cần chuyển sang số lam mã ");
        int n = sc.nextInt();
        System.out.println(map.get(n));
    }
}
