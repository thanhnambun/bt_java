import java.util.Scanner;

public class bt2 {
    public  static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("vui lòng nhập số thứ 1 ");
        int a = sc.nextInt();
        System.out.println("vui lòng nhập số thứ 2 ");
        int b = sc.nextInt();
        System.out.println("vui lòng nhập số thứ 3 ");
        int c = sc.nextInt();
        if( a == b && a== c ){
            System.out.println("Ba số nguyên bằng nhau");
        }else {
            if (a>b && a>c){
                System.out.printf("số lớn nhất là %d",a);
            }
            if (b>a && b>c){
                System.out.printf("số lớn nhất là %d",b);
            }
            if (c>a && c>b){
                System.out.printf("số lớn nhất là %d",c);
            }
        }
        sc.close();
    }
}
