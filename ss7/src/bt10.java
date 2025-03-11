import java.util.Scanner;

public class bt10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("vui lòng nhâp chuỗi ");
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder(str);
        do {
            System.out.println("menu quản lý chuỗi");
            System.out.println("1. đảo ngược chuỗi");
            System.out.println("2. chèn chuỗi vào vị trí bất kì ");
            System.out.println("3. xóa 1 đoạn trong chuỗi ");
            System.out.println("4. thay thế 1 đoạn trong chuỗi  ");
            System.out.println("5. chuyển toàn bộ chuỗi thành chữ in hoa / in thường ");
            System.out.println("6.thoát chương trình ");
            System.out.println("vui lòng nhập lựa chọn của bạn ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    sb.reverse();
                    System.out.println("chuỗi sau khi được đảo ngược là :" + sb);
                    break;
                case 2:
                    System.out.println("vui lòng nhập vị trí cần chèn ");
                    int insertSb = Integer.parseInt(sc.nextLine());
                    sb.insert(insertSb, sb);
                    System.out.println("chuỗi sau khi được chèn là :" + sb);
                    break;
                case 3:
                    System.out.println("vui lòng nhập vị trí bắt đầu xóa ");
                    int deleteSb1 = Integer.parseInt(sc.nextLine());
                    System.out.println("vui lòng nhập vị trí kết thúc xóa ");
                    int deleteSb2 = Integer.parseInt(sc.nextLine());
                    sb.delete(deleteSb1, deleteSb2);
                    System.out.println("chuỗi sau khi xóa là :" + sb);
                    break;
                case 4:
                    System.out.println("vui lòng nhập vị trí bắt đầu thay thế ");
                    int replaceSb1 = Integer.parseInt(sc.nextLine());
                    System.out.println("vui lòng nhập vị trí kết thúc thay thế ");
                    int replaceSb2 = Integer.parseInt(sc.nextLine());
                    System.out.println("nhập chuỗi thay thế ");
                    String replaceSb3 = sc.nextLine();
                    sb.replace(replaceSb1, replaceSb2, replaceSb3);
                    System.out.println("chuỗi sau khi thay thế là :" + sb);
                    break;
                case 5:
                    String sbToUpperCase = sb.toString().toUpperCase();
                    System.out.println("chuỗi sau khi được biến thành in hoa là " + sbToUpperCase);
                    String sbToLowerCase = sb.toString().toLowerCase();
                    System.out.println("chuỗi sau khi được biến thành in thường là " + sbToLowerCase);
                    break;
                case 6:
                    System.out.println("đã thoat chương trình");
                    System.exit(0);
                    break;
                default:
                    System.out.println("lựa chọn không hợp lệ . Vui lòng chọn lại");
            }
        } while (true);
    }
}
