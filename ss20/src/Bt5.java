
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Bt5 {
    public static void main(String[] args) {
        List<Integer> normalList = List.of(10, 5, 8, 20, 7);
        Optional<Integer> x= normalList.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst();
        x.ifPresentOrElse(System.out::println,() -> System.out.println("không thấy "));
    }
}
