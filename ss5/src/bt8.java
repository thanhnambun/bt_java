import java.util.Scanner;

public class bt8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] mark = new int[1000];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            mark[arr[i]]++;
        }
        int flag = 0;
        for (int i = 0; i < 1000; i++) {
            if (mark[i] == 1) {
                System.out.print(i + " ");
                flag = 1;
            }
        }
        System.out.println();
        if (flag == 0) {
            System.out.println("mang khong co phan tu doc nhat");
        }
    }
}