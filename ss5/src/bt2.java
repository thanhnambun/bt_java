import java.util.Scanner;

public class bt2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("vui lòng nhập kích thước mảng");
        int n = sc.nextInt();
        int [] arr = new int [n];
        System.out.println("vui lòng nhập giá trị các phanaf của mảng");
        for(int j=0;j<arr.length;j++){
            System.out.printf("arr[%d]=",j);
            arr[j] = sc.nextInt();
        }
        int sum=0;
        for(int i=0;i<arr.length;i++){
                sum +=arr[i];
        }
        System.out.printf("sum=%d",sum);
        sc.close();
    }
}
