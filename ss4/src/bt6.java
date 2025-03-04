import java.util.Scanner;

public class bt6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("vui lòng nhập số nguyên ");
        int n = sc.nextInt();
        int number = Math.abs(n);
        int sum = 0;
        while (number > 0){
            sum += number % 10;
            number /= 10;
        }
        System.out.printf("tổng các chữ số của số nguyên %d là :%d ",number,sum);
    }
}
