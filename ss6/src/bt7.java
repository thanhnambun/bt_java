import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class bt7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String[] emails = str.split("[,\\s]+");


        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        Pattern pattern = Pattern.compile(emailRegex);

        for (String email : emails) {
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                String[] parts = email.split("@");
                String username = parts[0];
                String domain = parts[1];
                System.out.println("Tên người dùng: " + username + ", tên miền: " + domain);
            } else {
                System.out.println("Email không hợp lệ: " + email);
            }
        }

    }
}