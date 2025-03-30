import java.io.*;

public class Bt3 {
    public static void main(String[] args) {
        String inputFileName = "input.txt";
        String copyFileName = "copy.txt";
        String content = "Đây là nội dung của tệp input.txt. Chương trình sẽ sao chép nó.";

        createFile(inputFileName, content);

        copyFile(inputFileName, copyFileName);

        readFile(copyFileName);
    }

    public static void createFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
            System.out.println("Đã tạo file " + fileName + " và ghi nội dung thành công.");
        } catch (IOException e) {
            System.out.println("Lỗi khi tạo file: " + e.getMessage());
        }
    }

    public static void copyFile(String source, String destination) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Đã sao chép nội dung từ " + source + " sang " + destination);
        } catch (IOException e) {
            System.out.println("Lỗi khi sao chép file: " + e.getMessage());
        }
    }

    public static void readFile(String fileName) {
        System.out.println("Nội dung file " + fileName + ":");
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }
}
