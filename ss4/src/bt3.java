import java.util.Scanner;

public class bt3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("vui lòng nhập số nguyên dương");
        int num =Integer.parseInt(sc.nextLine());
        System.out.println("bảng cửu chương");
        for(int a=1;a<=10;a++){
            System.out.printf("%d * %d =  %d\n ",num ,a,num*a);
        }
    }
}
