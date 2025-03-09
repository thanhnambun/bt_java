import java.util.Scanner;

public class bt10 {
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
        boolean check = false;
        int max=0;
        for (int i=0;i<arr.length;i++){
            if(arr[i]>0){
                check=true;
            }
        }
        if(check){
            for(int i=0;i<arr.length;i++){
                if(arr[i]>max){
                    max=arr[i];
                }
            }
            System.out.println(max +" tất cả đều là số âm.");
        }
        int maxSum = arr[0];
        int currentSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
    }
}
