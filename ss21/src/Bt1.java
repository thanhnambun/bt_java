import java.util.Scanner;

public class Bt1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("vui lòng nhập 2 số nguyên ");
        int n = sc.nextInt();
        int m = sc.nextInt();
        try{
            int sum = n/m;
            System.out.println(sum);
        }
        catch (ArithmeticException e){
            System.out.println("không thể chia cho 0 ");
        }finally {
            sc.close();
        }
    }
}
