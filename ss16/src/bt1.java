import java.util.ArrayList;
import java.util.Iterator;

public class bt1 {
    public static void main(String[] args) {
        ArrayList<String> studentList = new ArrayList<>();

        studentList.add("Nguyen Van A");
        studentList.add("Tran Thi B");
        studentList.add("Le Van C");
        studentList.add("Pham Thi D");
        studentList.add("Hoang Van E");

        System.out.println("danh sách sinh viên");
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i));
        }

        System.out.println(" danh sách sinh viên");
        for (String student : studentList) {
            System.out.println(student);
        }

        System.out.println(" danh sách sinh viên");
        Iterator<String> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            String student = iterator.next();
            System.out.println( student);
        }
    }
}
