import java.util.Scanner;

public class bt10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Kiểm tra số nguyên tố");
            System.out.println("2. Kiểm tra số hoàn hảo");
            System.out.println("3. Tính tổng các ước của số");
            System.out.println("4. Thoát chương trình");
            System.out.print("Nhập lựa chọn của bạn: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Nhập số cần kiểm tra: ");
                    int num = sc.nextInt();
                    boolean isPrime = true;
                    if(num < 2){
                        System.out.println("Không phải số nguyên tố");
                    }else {
                        for(int i=2;i<=Math.sqrt(num);i++){
                            if(num%i==0){
                                System.out.printf(" %d không phải số nguyên tố",num);
                                isPrime = false;
                                break;
                            }
                        }
                        if(isPrime){
                            System.out.println(num + " là số nguyên tố");
                        }
                    }
                    break;

                case 2:
                    System.out.print("Nhập số cần kiểm tra: ");
                    int num2 = sc.nextInt();
                    int sum = 0;
                    for (int j = 1; j < num2; j++) {
                        if(num2 % j==0){
                            sum +=j;
                        }
                    }
                    if(sum == num2){
                        System.out.print(num2+" là số nguyên hoàn hảo");
                    }else {
                        System.out.print(num2+" khoong là số hoàn hảo");
                    }
                    break;

                case 3:
                    System.out.print("Nhập số cần tính tổng ước: ");
                    int num3 = sc.nextInt();
                    int sum2 = 0;
                    for (int j = 1; j <= num3; j++) {
                        if(num3 % j==0){
                            sum2 +=j;
                        }
                    }
                    System.out.println("Tổng các ước của " + num3 + " là: " + sum2);
                    break;

                case 4:
                    System.out.println("Thoát chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 4);

        sc.close();
    }
}
