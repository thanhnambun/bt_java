import java.util.Random;

public class bt6 {
    public static void main(String[] args) {
        int[] markingArray = new int[1001];
        int[] originalArray = {5, 12, 7, 5, 20, 12, 15, 7, 30, 5, 25, 30, 12, 20, 7, 25, 30, 5, 12, 7};

        for (int i = 0; i < originalArray.length; i++) {
            System.out.print(originalArray[i] + " ");
            markingArray[originalArray[i]]++;
        }
        System.out.println("\n");

        int maxCount = 0;
        for (int i = 1; i <= 1000; i++) {
            if (markingArray[i] > maxCount) {
                maxCount = markingArray[i];
            }
        }

        System.out.println("Phần tử xuất hiện nhiều nhất:");
        for (int i = 1; i <= 1000; i++) {
            if (markingArray[i] == maxCount) {
                System.out.printf("Số %d xuất hiện %d lần\n", i, maxCount);
            }
        }
    }
}
