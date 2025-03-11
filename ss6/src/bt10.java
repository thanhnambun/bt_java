import java.util.Scanner;

public class bt10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập đoạn văn bản: ");
        String input = scanner.nextLine();
        boolean isEmpty = true;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ' ') {
                isEmpty = false;
                break;
            }
        }
        if (isEmpty) {
            System.out.println("Không có văn bản để xử lý.");
            return;
        }
        String cleanedText = "";
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9') || ch == ' ') {
                cleanedText += ch;
            }
        }
        String lowerText = "";
        for (int i = 0; i < cleanedText.length(); i++) {
            char ch = cleanedText.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                lowerText += (char) (ch + 32);
            } else {
                lowerText += ch;
            }
        }
        String normalizedText = "";
        boolean spaceFound = false;
        for (int i = 0; i < lowerText.length(); i++) {
            char ch = lowerText.charAt(i);
            if (ch == ' ') {
                if (!spaceFound && normalizedText.length() > 0) {
                    normalizedText += ' ';
                }
                spaceFound = true;
            } else {
                normalizedText += ch;
                spaceFound = false;
            }
        }
        String numbers = "";
        boolean isNumber = false;
        for (int i = 0; i < normalizedText.length(); i++) {
            char ch = normalizedText.charAt(i);
            if (ch >= '0' && ch <= '9') {
                if (!isNumber) {
                    numbers += "[";
                }
                numbers += ch;
                isNumber = true;
            } else {
                if (isNumber) {
                    numbers += ", ";
                    isNumber = false;
                }
            }
        }
        if (numbers.length() > 0 && numbers.charAt(numbers.length() - 2) == ',') {
            numbers = numbers.substring(0, numbers.length() - 2);
        }
        if (!numbers.isEmpty()) {
            numbers += "]";
        } else {
            numbers = "Không có số nào trong văn bản.";
        }
        String textWithoutNumbers = "";
        for (int i = 0; i < normalizedText.length(); i++) {
            char ch = normalizedText.charAt(i);
            if (!(ch >= '0' && ch <= '9')) {
                textWithoutNumbers += ch;
            }
        }
        System.out.println("Văn bản đã chuẩn hóa: " + textWithoutNumbers);
        System.out.println("Các số tìm thấy: " + numbers);
    }
}