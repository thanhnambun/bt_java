import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Bt8 {
    private String name;
    private String major;
    private double score;

    public Bt8(String name, String major, double score) {
        this.name = name;
        this.major = major;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public static void main(String[] args) {
        List<Bt8> students = List.of(

                new Bt8("Quý", "IT", 8.5),

                new Bt8("Lan", "Business", 7.2),

                new Bt8("Minh", "IT", 9.0),

                new Bt8("Huyền", "Design", 6.8),

                new Bt8("Long", "IT", 7.9),

                new Bt8("Trang", "Business", 8.1),

                new Bt8("Việt", "IT", 8.0),

                new Bt8("Tú", "Design", 7.5),

                new Bt8("Phúc", "Business", 6.9),

                new Bt8("An", "AI", 9.5)

        );
        Map<String ,Long> map = students.stream().collect(Collectors.groupingBy(item->item.getMajor(), Collectors.counting()));
        System.out.println(map);
    }
}
