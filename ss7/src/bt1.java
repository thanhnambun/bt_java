import java.util.Scanner;

public class bt1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập chuỗi thứ nhất: ");
        String str1 = sc.nextLine();

        System.out.print("Nhập chuỗi thứ hai: ");
        String str2 = sc.nextLine();

        System.out.print("Nhập chuỗi thứ ba: ");
        String str3 = sc.nextLine();

        StringBuilder sb = new StringBuilder();
        sb.append(str1);
        sb.append(" ");
        sb.append(str2);
        sb.append(" ");
        sb.append(str3);

        String result = sb.toString().toUpperCase();

        System.out.println("Chuỗi sau khi nối và chuyển thành chữ hoa: " + result);

        sc.close();
    }
}
