import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Collections;

public class Bt6 {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "copy2.txt";


        String reversedContent = reverseFileContent(inputFile);

        writeFile(outputFile, reversedContent);

        System.out.println("Nội dung sau khi đảo ngược:");
        readFile(outputFile);
    }


    public static String reverseFileContent(String fileName) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            StringBuilder reversed = new StringBuilder();
            for (String line : lines) {
                reversed.append(new StringBuilder(line).reverse()).append("\n");
            }
            return reversed.toString().trim();
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
            return "";
        }
    }

    public static void writeFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    public static void readFile(String fileName) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }
}
