import java.io.*;

public class Bt4 implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private double score;

    public Bt4(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public void displayInfo() {
        System.out.println("Tên: " + name);
        System.out.println("Tuổi: " + age);
        System.out.println("Điểm số: " + score);
    }


    public static void main(String[] args) {
        String fileName = "student.dat";

        Bt4 student = new Bt4("Nguyễn Văn A", 20, 8.5);

        writeStudentToFile(fileName, student);

        Bt4 readStudent = readStudentFromFile(fileName);
        if (readStudent != null) {
            readStudent.displayInfo();
        }
    }

    public static void writeStudentToFile(String fileName, Bt4 student) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(student);
            System.out.println("Đã ghi đối tượng vào file " + fileName);
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    public static Bt4 readStudentFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            System.out.println("Đã đọc đối tượng từ file " + fileName);
            return (Bt4) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
            return null;
        }
    }
}