package validate;

import javax.xml.validation.Validator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PersonValidate {
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@gmail\\.com$";
    private static final String VIETNAM_PHONE_REGEX = "^(0|\\+84)[0-9]{7}$";
    public static String validateEmail(Scanner sc) {
        do {
            String email = ValueDator.validateString(sc,new StringRule(255,1),"vui longf nhập email");
            if (Pattern.matches(EMAIL_REGEX, email)) {
                return email;
            }
            System.err.println("Email không hợp lệ! Vui lòng nhập lại (chỉ chấp nhận Gmail).");
        } while (true);
    }


    public static String validatePhone(Scanner sc) {
        do {
            String phone = sc.nextLine();
            if (Pattern.matches(VIETNAM_PHONE_REGEX, phone)) {
                return phone;
            }
        } while (true);
    }
}
