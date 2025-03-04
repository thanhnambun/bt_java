import java.util.Scanner;

public class bt1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("vui lòng nhập số nguyên dương");
        int num =Integer.parseInt(sc.nextLine());
        int sum=0;
        if (num <0){
            System.out.println("Số nhập vào không hợp lệ");
        }
         for (int i = 1; i <= num; i++){
             sum += i;
         }
        System.out.printf("tổng là %d",sum);
         sc.close();
    }
}
