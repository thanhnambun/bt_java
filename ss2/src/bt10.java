import java.util.Scanner;
import java.math.BigInteger;

public class bt10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số nguyên lớn a: ");
        String a = sc.nextLine();
        System.out.print("Nhập số nguyên lớn b: ");
        String b = sc.nextLine();

        BigInteger x = new BigInteger(a);
        BigInteger y = new BigInteger(b);


        BigInteger sum = x.add(y);
        BigInteger difference = x.subtract(y);
        BigInteger product = x.multiply(y);
        BigInteger quotient = x.divide(y);
        BigInteger remainder = x.mod(y);
        BigInteger power = x.pow(10);

        System.out.println("\n---- Kết quả ----");
        System.out.println("Tổng: " + sum);
        System.out.println("Hiệu: " + difference);
        System.out.println("Tích: " + product);
        System.out.println("Thương: " + quotient);
        System.out.println("Số dư: " + remainder);
        System.out.println("Lũy thừa bậc 10 của a: " + power);

        sc.close();
    }
}
