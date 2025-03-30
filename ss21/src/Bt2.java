import java.util.Scanner;

public class Bt2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = {10, 20, 30, 40, 50};

        System.out.print("Nhập chỉ số phần tử của mảng: ");
        try {
            int n = sc.nextInt();
            System.out.println(numbers[n-1]);
        }catch (Exception e){
            System.out.println("khoong có chỉ số cần tìm");
        }finally {
            sc.close();
        }
    }
}
