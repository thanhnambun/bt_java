import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Bt2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> setHashSet = new HashSet<String>();
        setHashSet.add("Java");
        setHashSet.add("C++");
        setHashSet.add("Python");
        setHashSet.add("HTML");
        System.out.println("vui lòng nhập cchuỗi cần kiểm tra");
        setHashSet.contains(sc.nextLine());
    }
}
