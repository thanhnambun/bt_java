import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class bt10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();

        if (input.isEmpty()) {
            System.out.println("Không có văn bản để xử lý.");
            return;
        }

        String cleanedText = input.replaceAll("[^a-zA-Z0-9\\s]", "");

        cleanedText = cleanedText.toLowerCase();
        cleanedText = cleanedText.replaceAll("\\s+", " ").trim();

        ArrayList<String> numbers = new ArrayList<>();
        Pattern numberPattern = Pattern.compile("\\d+");
        Matcher matcher = numberPattern.matcher(cleanedText);
        while (matcher.find()) {
            numbers.add(matcher.group());
        }


        System.out.println("Văn bản đã chuẩn hóa: " + cleanedText);
        System.out.println("Danh sách các số: " + numbers);

    }
}