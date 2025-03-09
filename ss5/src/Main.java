import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[100];
        Scanner sc = new Scanner(System.in);
        int curentIndex  = 0;
        do{
            System.out.println("****************MENU*****************");
            System.out.println("1. nhap vao gia tri cac phan tu");
            System.out.println("2. In ra cac phan tu");
            System.out.println("3. Tinh tong cac phan tu");
            System.out.println("4. In ra cac phan tu chia het cho 3 va tinh tong");
            System.out.println("5. In ra cac phan tu la so nguyen to va tinh tong");
            System.out.println("6. Thoat");
            System.out.println("nhap lua chon");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.println("nhap so phan tu can nhap");
                    int n = Integer.parseInt(sc.nextLine());

                    for (int i = 0; i < n; i++) {
                        arr[i] = Integer.parseInt(sc.nextLine());
                        curentIndex++;
                    }
                    break;
                case 2:
                    for (int i = 0; i < arr.length; i++) {
                        System.out.println(arr[i]);
                    }
                    break;
                case 3:
                    int sum = 0;
                    for (int i = 0; i < arr.length; i++) {
                        sum += arr[i];
                    }
                    System.out.printf("tong cac phan tu %d",sum);
                    break;
                case 4:
                    int  sum2 = 0;
                    for (int i = 0; i < arr.length; i++) {
                        if(arr[i]% 3 == 0){
                            sum2 += arr[i];
                        }
                    }
                    System.out.printf("tong cac phan tu %d \n",sum2);
                    break;
                case 5:
                    int sum3 = 0;
                    for (int i = 0; i < arr.length; i++) {
                        boolean check = true;

                        if (arr[i] < 2) {
                            check = false;
                        } else {
                            for (int j = 2; j <= Math.sqrt(arr[i]); j++) {
                                if (arr[i] % j == 0) {
                                    check = false;
                                    break;
                                }
                            }
                        }

                        if (check) {
                            sum3 += arr[i];
                        }
                    }

                    System.out.printf("Tổng các phần tử là số nguyên tố: %d\n", sum3);

                    break;
                case 6:
                    break;
            }

        }while(true);
    }
}