import java.util.Scanner;

public class Bt5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Vui lòng nhập số: ");

        try {
            int n = sc.nextInt();
            boolean isPrime = true;

            if (n < 2) {
                isPrime = false;
            } else {
                for (int i = 2; i <= Math.sqrt(n); i++) {
                    if (n % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

            if (isPrime) {
                System.out.println(n + " là số nguyên tố.");
            } else {
                System.out.println(n + " không phải số nguyên tố.");
            }
        } catch (Exception e) {
            System.out.println("Lỗi: Bạn đã nhập sai định dạng!");
        } finally {
            sc.close();
        }
    }
}
