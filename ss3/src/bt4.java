import java.util.Scanner;

public class bt4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("vui lòng nhập ngayf");
        int day = Integer.parseInt(sc.nextLine());
        switch (day) {
            case 1:
                System.out.println("ngày thứ 2 ");
                break;
            case 2:
                System.out.println("ngày thứ 3 ");
                break;
            case 3:
                System.out.println("ngày thứ 4 ");
                break;
            case 4:
                System.out.println("ngày thứ 5 ");
                break;
            case 5:
                System.out.println("ngày thứ 6 ");
                break;
            case 6:
                System.out.println("ngày thứ 7 ");
                break;
            case 7:
                System.out.println("ngày thứ Chủ nhật ");
                break;
            default:
                System.out.println("không có");
        }
        sc.close();
    }
}
