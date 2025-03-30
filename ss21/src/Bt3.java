import java.util.Scanner;

public class Bt3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("vui lòng nhập tuổi ");
        int n = sc.nextInt();
        checkAge(n);
    }
    public static void checkAge(int age ){
        if(age<18){
            throw  new IllegalArgumentException("tuổi không hợp lệ");
        }
        System.out.println("chafo mừng bạn ");
    }
}
