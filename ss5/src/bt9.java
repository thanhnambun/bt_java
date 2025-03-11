public class bt9 {
    public static void main(String[] args) {
        int [][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int n = arr.length;
        int [][] newArr = new int[n][n];

        System.out.println(arr.length);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newArr[j][n - 1 - i] = arr[i][j];
            }
        }


        System.out.println("Ma trận sau khi xoay 90 độ:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d", newArr[i][j]);
            }
            System.out.println();
        }
    }
}
