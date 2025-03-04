import java.util.Scanner;

public class bt7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("vui lòng nhập số nguyên dương");
        int number = Integer.parseInt(sc.nextLine());
        do {
            if(number<1){
                System.out.println("vui lòng nhập lại số nguyên dương");
                number = Integer.parseInt(sc.nextLine());
            }else {
                break;
            }
        }while(true);
        System.out.printf("các số happy nhỏ hơn %d là :",number);
        for (int i = 1; i <= number; i++) {
            int sum = i;
            int temp;
            while (sum != 1 && sum != 4) {
                temp = sum;
                sum = 0;
                while (temp > 0) {
                    int digit = temp % 10;
                    sum += digit * digit;
                    temp /= 10;
                }
            }
            if (sum == 1) {
                System.out.printf(i + " ");
            }
        }
        sc.close();
    }
}
