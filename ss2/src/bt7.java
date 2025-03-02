import java.time.LocalTime;
import java.util.Scanner;

public class bt7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập giờ ban đầu: ");
        int startHour = scanner.nextInt();
        System.out.print("Nhập phút ban đầu: ");
        int startMinute = scanner.nextInt();
        System.out.print("Nhập giây ban đầu: ");
        int startSecond = scanner.nextInt();

        System.out.print("Nhập số giờ cần cộng: ");
        int addHour = scanner.nextInt();
        System.out.print("Nhập số phút cần cộng: ");
        int addMinute = scanner.nextInt();
        System.out.print("Nhập số giây cần cộng: ");
        int addSecond = scanner.nextInt();

        int allTimeInSeconds = (startHour * 3600 + startMinute * 60 + startSecond) +(addHour * 3600 + addMinute * 60 + addSecond);

        int result_hour = allTimeInSeconds / 3600;
        int  result_minute = allTimeInSeconds % 3600 / 60;
        int  result_second = allTimeInSeconds % 60;
        System.out.printf("Thời gian sau khi cộng: %d giờ %d phút %d giây ",result_hour,result_minute,result_second );

        scanner.close();
    }
}
