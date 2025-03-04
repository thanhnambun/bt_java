import java.util.Scanner;

public class bt5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count =0 ;

        System.out.println("vui lòng nhập số nguyên dương");
        int n = sc.nextInt();
        System.out.printf("các hoàn hảo từ 1 - %d là : \n",n);
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j < i; j++) {
                if(i % j==0){
                    sum +=j;
                }
            }
            if(sum == i){
                System.out.print(i);
                count ++;
            }
        }
        if(count==0){
            System.out.println("không có số hoàn hảo nào ");
        }
    }
}
