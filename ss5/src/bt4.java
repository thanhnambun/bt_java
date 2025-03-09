import java.util.Scanner;

public class bt4 {
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
        System.out.println("chuỗi được đảo lại là");
        System.out.print("[ ");
        for(int i=arr.length-1;i>=0;i--){
            System.out.printf("%d ",arr[i]);
        }
        System.out.print("]");
    }
}
