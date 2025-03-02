import java.util.Scanner;

public class bt5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("vui lòng nhập chiều dài và chiều rộng của hình chữ nhật");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        System.out.printf("Diện tích của hình chữ nhật là : %d \n", num1 * num2);
        System.out.printf("chu vi của hình chữ nhật là : %d",2*(num1+num2));
        scanner.close();
    }
}