import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Bt5 {
    public static void main(String[] args) {
        String fileName = "input.txt";

        createFileWithPlayers(fileName);

        findLongestName(fileName);
    }

    public static void createFileWithPlayers(String fileName) {
        String[] players = {
               "văn lâm",
                "tiến linh",
                "xuân son",
                "văn hậu"
        };

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String player : players) {
                writer.write(player);
                writer.newLine();
            }
            System.out.println("Đã tạo file " + fileName + " với danh sách cầu thủ.");
        } catch (IOException e) {
            System.out.println("Lỗi khi tạo file: " + e.getMessage());
        }
    }

    public static void findLongestName(String fileName) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            String longestName = "";

            for (String name : lines) {
                if (name.length() > longestName.length()) {
                    longestName = name;
                }
            }

            System.out.println("Tên cầu thủ dài nhất: " + longestName);
            System.out.println("Độ dài của tên đó: " + longestName.length());
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }
}
