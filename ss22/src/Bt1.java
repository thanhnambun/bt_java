import java.io.*;
import java.util.Scanner;

public class Bt1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "output.txt";

        System.out.print("Nhập: ");
        String inputText = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(inputText);
            System.out.println("Đã ghi vào file " + fileName);
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }

        System.out.println("Nội dung trong file:");
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }

        scanner.close();
    }
}
