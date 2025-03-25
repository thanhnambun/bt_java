import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Bt1 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Java", "", "Lambda", "Stream", "", "Functional");
        Predicate<String>  predicates = s -> !s.isEmpty();
        for(String s : strings) {
            if (predicates.test(s)) {
                System.out.println(s);
            }
        }
    }
}
