import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class bt9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String url = sc.nextLine().trim();

        String urlRegex = "^(https?)://([^/]+)(/.*)?$";
        Pattern pattern = Pattern.compile(urlRegex);
        Matcher matcher = pattern.matcher(url);

        if (matcher.matches()) {
            String protocol = matcher.group(1);
            String domain = matcher.group(2);
            String path = matcher.group(3) != null ? matcher.group(3) : "/";

            System.out.println(" Giao thức: " + protocol);
            System.out.println(" Tên miền: " + domain);
            System.out.println(" Đường dẫn: " + path);
        } else {
            System.out.println("URL không hợp lệ!");
        }


    }
}