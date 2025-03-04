import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vui lòng nhập số nguyên dương:");
        int number = Integer.parseInt(sc.nextLine());

        // Kiểm tra đầu vào hợp lệ
        while (number < 1) {
            System.out.println("Vui lòng nhập lại số nguyên dương:");
            number = Integer.parseInt(sc.nextLine());
        }

        System.out.printf("Các số Happy nhỏ hơn %d là: ", number);

        for (int i = 1; i < number; i++) {
            int slow = i, fast = i;
            do {
                // Tính tổng bình phương chữ số
                int sum1 = 0, temp1 = slow;
                while (temp1 > 0) {
                    int digit = temp1 % 10;
                    sum1 += digit * digit;
                    temp1 /= 10;
                }
                slow = sum1;

                int sum2 = 0, temp2 = fast;
                while (temp2 > 0) {
                    int digit = temp2 % 10;
                    sum2 += digit * digit;
                    temp2 /= 10;
                }
                fast = sum2;

                sum2 = 0;
                temp2 = fast;
                while (temp2 > 0) {
                    int digit = temp2 % 10;
                    sum2 += digit * digit;
                    temp2 /= 10;
                }
                fast = sum2;

            } while (slow != fast && fast != 1);

            if (fast == 1) {
                System.out.print(i + " ");
            }
        }

        System.out.println();
        sc.close();
    }
}
