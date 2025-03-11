import java.util.Scanner;

public class bt3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập chuỗi : ");
        String str1 = sc.nextLine();
        StringBuilder sb1=new StringBuilder(str1);
        sb1.reverse();
        System.out.println(sb1);
    }
}
