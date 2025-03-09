import java.util.Scanner;
import java.util.regex.Pattern;

public class bt8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();


        String[] phoneNumbers = input.replaceAll("[\\[\\]\"]", "").split("[,\\s]+");

        for (String phone : phoneNumbers) {

            phone = phone.replaceAll("[.\\-\\s]", "");

            Pattern patternVN = Pattern.compile("^(0\\d{9}|\\+84\\d{9})$");
            if (!patternVN.matcher(phone).matches()) {
                System.out.println("Số điện thoại không hợp lệ");
                continue;
            }

            if (phone.startsWith("0")) {
                phone = "+84" + phone.substring(1);
            }

            String formattedPhone = phone.replaceFirst("\\+84(\\d{3})(\\d{3})(\\d{3})", "+84 $1 $2 $3");
            System.out.println(formattedPhone);
        }

    }
}