import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Bt7 {
    private int id;
    private String name;
    private String code;
    public Bt7(int id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public void display() {
        System.out.println("ID: " + id + ", Code: " + code + ", Name: " + name);
    }
    public static void main(String[] args) {
        List<Bt7> countryList = new ArrayList<>();
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt")))
        {
            writer.write("1,VN,Vietnam\n");
            writer.write("2,US,United States\n");
            writer.write("3,JP,Japan\n");
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0].trim());
                    String code = parts[1].trim();
                    String name = parts[2].trim();
                    countryList.add(new Bt7(id, code, name));
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
        for (Bt7 country : countryList) {
            country.display();
        }
    }
}
