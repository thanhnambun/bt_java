
import java.util.Scanner;

public class bt7 {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);

        System.out.print("Nhập cạnh a: ");
        int a = sc.nextInt();
        System.out.print("Nhập cạnh b: ");
        int b = sc.nextInt();
        System.out.print("Nhập cạnh c: ");
        int c = sc.nextInt();

        if (a + b > c && a + c > b && b + c > a) {
            System.out.print("Ba cạnh tạo thành một tam giác ");

            if (a == b && b == c) {
                System.out.println("đều.");
            } else if (a == b || b == c || a == c) {
                System.out.println("cân.");
            } else if (a * a + b * b == c * c ||
                    a * a + c * c == b * b ||
                    b * b + c * c == a * a) {
                System.out.println("vuông.");
            } else {
                System.out.println("thường.");
            }
        } else {
            System.out.println("Ba cạnh không tạo thành tam giác.");
        }

        sc.close();
    }
}
