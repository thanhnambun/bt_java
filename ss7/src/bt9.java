import java.util.Scanner;

public class bt9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" vui lòng nhập chuỗi chữ ");
        String str = sc.nextLine();
        char ch = str.charAt(0);
        StringBuilder newStr = new StringBuilder();
        int count = 1;
        for (int i = 1; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                newStr.append(str.charAt(i)).append(count);
                count = 1;
            }
        }
        newStr.append(str.charAt(str.length() - 1)).append(count);
        System.out.println("Chuỗi sau khi được nén là  " + newStr.toString());
    }
}
