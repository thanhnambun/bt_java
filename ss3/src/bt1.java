import java.util.Scanner;

public class bt1 {
    public  static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("vui lòng nhập số caafn kiểm tra");
        int n = sc.nextInt();
         if(n%2==0){
             System.out.println("chẵn");
         }else {
             System.out.println("lẻ");
         }
         sc.close();
    }
}
