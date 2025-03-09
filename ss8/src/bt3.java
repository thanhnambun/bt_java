import java.util.Scanner;

public class bt3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập email: ");
        String email = sc.nextLine();

        System.out.print("Nhập mật khẩu: ");
        String password = sc.nextLine();

        boolean emailValid = false;
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        if (email.matches(emailRegex)) {
            emailValid = true;
        }

        boolean passwordValid = false;

        if (password.length() >= 8) {
            boolean hasUpperCase = false;
            boolean hasLowerCase = false;
            boolean hasDigit = false;
            boolean hasSpecialChar = false;
            String specialChars = "@#$!%";

            for (char c : password.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    hasUpperCase = true;
                } else if (Character.isLowerCase(c)) {
                    hasLowerCase = true;
                } else if (Character.isDigit(c)) {
                    hasDigit = true;
                } else if (specialChars.indexOf(c) >= 0) {
                    hasSpecialChar = true;
                }
            }

            if (hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar) {
                passwordValid = true;
            }
        }

        if (emailValid && passwordValid) {
            System.out.println("Email và mật khẩu hợp lệ");
        } else if (emailValid) {
            System.out.println("Email hợp lệ, mật khẩu không hợp lệ");
        } else if (passwordValid) {
            System.out.println("Email không hợp lệ, mật khẩu hợp lệ");
        } else {
            System.out.println("Email và mật khẩu không hợp lệ");
        }

        sc.close();
    }
}
