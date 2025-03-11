import java.util.Scanner;

public class bt8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        System.out.println("vui lòng nhập độ dài mã cần tạo ");
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            int random = (int) Math.floor(Math.random() * chars.length());
            sb.append(chars.charAt(random));
        }
        System.out.println(sb);
    }
}
