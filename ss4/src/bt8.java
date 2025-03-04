import java.util.Scanner;

public class bt8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("vui lòng nhập số nguyên dương");
        int number = Integer.parseInt(sc.nextLine());
        int sum = 0;
        do {
            if(number<1){
                System.out.println("Số nhập vào không hợp lệ .Vui lòng nhập lại số nguyên dương");
                number = Integer.parseInt(sc.nextLine());
            }else {
                break;
            }
        }while(true);
        System.out.printf("tất cả các số Armstrong từ 1 đến %d là : \n",number);
        for (int j = 1; j <= number; j++) {
            int temp = j;
            while (temp > 0) {
                int digit = temp % 10;
                sum += digit * digit *digit;
                temp /= 10;
            }
            if (sum == j) {
                System.out.printf(j+" ");
            }
        }
        sc.close();
    }
}
