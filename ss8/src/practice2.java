import java.util.Scanner;

public class practice2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0, m = 0;
        int[][] matrix = new int[0][0];
        do {
            System.out.println("\n************ MENU ************");
            System.out.println("1. Nhập giá trị các phần tử của mảng");
            System.out.println("2. In mảng theo ma trận");
            System.out.println("3. Đếm số phần tử chia hết cho 2 và 3");
            System.out.println("4. In và tính tổng phần tử trên đường biên, chéo chính, chéo phụ");
            System.out.println("5. Sắp xếp các phần tử tăng dần theo cột (Selection Sort)");
            System.out.println("6. In các phần tử là số nguyên tố trong mảng");
            System.out.println("7. Sắp xếp đường chéo chính giảm dần (Insertion Sort)");
            System.out.println("8. Chèn mảng 1D vào dòng chỉ định");
            System.out.println("9. Thoát");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Nhập số hàng (n): ");
                    n = sc.nextInt();
                    System.out.print("Nhập số cột (m): ");
                    m = sc.nextInt();
                    matrix = new int[n][m];
                    System.out.println("Nhập các phần tử của mảng:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            matrix[i][j] = sc.nextInt();
                        }
                    }
                    break;
                case 2:
                    System.out.println("Mảng dưới dạng ma trận:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                             System.out.print(matrix[i][j] + " ");
                        }
                        System.out.println();
                    }
                break;
                case 3:
                    int count=0;
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            if(matrix[i][j]%2 ==0 && matrix[i][j]%3==0) {
                                count++;
                            }
                        }
                    }
                    System.out.println("các số chia heets cho 2 và 3 là : " + count);
                    break;
                case 4:
                    int sum = 0;
                    System.out.println("Các phần tử trên đường biên, chéo chính, chéo phụ:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            if (i == 0 || i == n - 1 || j == 0 || j == m - 1 || i == j || i + j == n - 1) {
                                System.out.print(matrix[i][j] + " ");
                                sum += matrix[i][j];
                            } else {
                                System.out.print("  ");
                            }
                        }
                        System.out.println();
                    }
                    System.out.println("Tổng các phần tử trên đường biên, chéo chính, chéo phụ: " + sum);
                    break;
                case 5:
                    for (int j = 0; j < m; j++) {
                        for (int i = 0; i < n - 1; i++) {
                            int minIndex = i;
                            for (int k = i + 1; k < n; k++) {
                                if (matrix[k][j] < matrix[minIndex][j]) {
                                    minIndex = k;
                                }
                            }
                            if (minIndex != i) {
                                int temp = matrix[i][j];
                                matrix[i][j] = matrix[minIndex][j];
                                matrix[minIndex][j] = temp;
                            }
                        }
                    }

                    System.out.println("Ma trận sau khi sắp xếp tăng dần theo cột:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            System.out.print(matrix[i][j] + " ");
                        }
                        System.out.println();
                    }
                    break;

                case 6:
                    System.out.println("các số nguyên tố trong ma trận là :");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            boolean isPrime = true;

                            if (matrix[i][j] <= 1) {
                                isPrime = false;
                            } else {
                                for (int k = 2; k <= Math.sqrt(matrix[i][j]); k++) {
                                    if (matrix[i][j] % k == 0) {
                                        isPrime = false;
                                        break;
                                    }
                                }
                            }

                            if (isPrime) {
                                System.out.println(matrix[i][j]+" ");
                            }
                        }
                    }
                    break;
                case 7:
                    int min = Math.min(n, m);
                    int[] diagonal = new int[min];

                    for (int i = 0; i < min; i++) {
                        diagonal[i] = matrix[i][i];
                    }

                    for (int i = 1; i < min; i++) {
                        int key = diagonal[i];
                        int j = i - 1;

                        while (j >= 0 && diagonal[j] < key) {
                            diagonal[j + 1] = diagonal[j];
                            j--;
                        }
                        diagonal[j + 1] = key;
                    }

                    for (int i = 0; i < min; i++) {
                        matrix[i][i] = diagonal[i];
                    }

                    System.out.println("Ma trận sau khi sắp xếp đường chéo chính giảm dần:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            System.out.print(matrix[i][j] + " ");
                        }
                        System.out.println();
                    }
                    break;

                case 8:
                    if (n == 0 || m == 0) {
                        System.out.println("Bạn cần nhập ma trận trước!");
                        break;
                    }

                    System.out.println("Nhập dòng cần chèn (0 đến " + (n - 1) + "): ");
                    int rowIndex = sc.nextInt();
                    if (rowIndex < 0 || rowIndex >= n) {
                        System.out.println("Vị trí dòng không hợp lệ!");
                        break;
                    }

                    int[] newRow = new int[m];
                    System.out.println("Nhập các phần tử cho dòng mới:");
                    for (int i = 0; i < m; i++) {
                        newRow[i] = sc.nextInt();
                    }

                    for (int i = 0; i < m; i++) {
                        matrix[rowIndex][i] = newRow[i];
                    }

                    System.out.println("Ma trận sau khi chèn dòng mới:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            System.out.print(matrix[i][j] + " ");
                        }
                        System.out.println();
                    }
                    break;

                case 9:
                    System.out.println("Thoát chương trình!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
            }

        }while (true);
    }
}

