import java.util.Arrays;
import java.util.Scanner;

public class bt7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("vui lòng nhập kích thước mảng");
        int n = sc.nextInt();
        int [] arr = new int [n];
        int [] newArr = new int [100];
        int curentIndex  = 0;
        System.out.println("vui lòng nhập giá trị các phanaf của mảng");
        for(int j=0;j<arr.length;j++){
            System.out.printf("arr[%d]=",j);
            arr[j] = sc.nextInt();
        }
        for(int j=0;j<arr.length;j++){
            if(arr[j]%2==0){
                newArr[curentIndex]=arr[j];
                curentIndex++;
            }
        }
        for(int j=0;j<arr.length;j++){
            if(arr[j] % 2 != 0){
                newArr[curentIndex] = arr[j];
                curentIndex++;
            }
        }
        for(int j=0;j<curentIndex;j++){
            System.out.printf("newArr[%d] = %d\n", j, newArr[j]);
        }
    }
}
