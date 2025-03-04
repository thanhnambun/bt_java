import java.util.Scanner;

public class bt9 {
    public static void main (String[]  args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("vui lòng nhập số nguyên dương");
        int number = Integer.parseInt(sc.nextLine());
        do {
            if(number<1){
                System.out.println("Số nhập vào không hợp lệ .Vui lòng nhập lại số nguyên dương");
                number = Integer.parseInt(sc.nextLine());
            }else {
                break;
            }
        }while(true);
        System.out.printf("tất cả các số Palindrome  từ 1 đến %d là : \n",number);
        for (int j = 1; j <= number; j++) {
            int temp = j;
            int reversedNumber = 0;
            while (temp > 0) {
                int digit = temp % 10;
                reversedNumber =reversedNumber * 10 + digit ;
                temp /= 10;
            }
            if (reversedNumber == j) {
                System.out.printf(j+" ");
            }
        }
        sc.close();
    }
}
