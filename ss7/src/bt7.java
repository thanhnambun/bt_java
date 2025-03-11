import java.util.Scanner;

public class bt7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập vào chuỗi PascalCase hoặc camelCase: ");
        String input = sc.nextLine();
        StringBuilder result = new StringBuilder();
        if (input == null || input.isEmpty()) {
            System.out.println("chuỗi đang bị rỗng vui lòng nhập lại ");
            input = sc.nextLine();
        }
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (Character.isUpperCase(ch)) {
                if (i != 0) {
                    result.append("_");
                }
                result.append(Character.toLowerCase(ch));
            } else {
                result.append(ch);
            }
        }
        System.out.println("Chuỗi snake_case: " + result.toString());
    }
}