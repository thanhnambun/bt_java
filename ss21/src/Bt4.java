import java.util.Scanner;

public class Bt4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("vui lòng nahapj số nguyên");
        int n = sc.nextInt();
        try {
            System.out.println(n);
        } catch (Exception e) {
            System.out.println("lỗi bnaj phải nhập số nguyên");
        }finally {
            System.out.println("cảm ơn ban jđã s dụng chương trình");
        }
    }
}
