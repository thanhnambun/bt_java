import java.util.Scanner;

public class bt6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String password = sc.nextLine();
        if (password.length() < 8) {
            System.out.println("Invalid password");
            return;
        }
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
            System.out.println("mat khau hop le");
        } else {
            System.out.println("mat khau khong hop le");
        }

    }
}