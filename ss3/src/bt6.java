
import java.util.Scanner;

public class bt6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập tháng (1-12): ");
        int month = sc.nextInt();

        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> System.out.println("Tháng " + month + " có 31 ngày.");
            case 4, 6, 9, 11 -> System.out.println("Tháng " + month + " có 30 ngày.");
            case 2 -> System.out.println("Tháng 2 có 28 hoặc 29 ngày.");
            default -> System.out.println("Tháng không hợp lệ.");
        }

        sc.close();
    }
}
