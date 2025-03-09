import java.util.Scanner;

public class bt5 {
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
        int max=arr[0];
        int min=arr[0];
        boolean flag=true;
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2 != 0){
                flag = false;
                if(arr[i]>max){
                    max=arr[i];
                }else if(arr[i]<min) {
                    min = arr[i];
                }
            }else {
                min=max;
            }

        }
        if( flag){
            System.out.println("Không có phần tử lẻ trong mảng");
        }else {
            System.out.printf("max=%d , min =%d",max,min);
        }

    }
}
