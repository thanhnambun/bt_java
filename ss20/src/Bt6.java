import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Bt6 {
    public static void main(String[] args) {
        List<String> items = List.of("apple", "banana", "apple", "orange", "banana", "apple");
        Map<String, Long> itemCount = items.stream()
                .collect(Collectors.groupingBy(item -> item, Collectors.counting()));
        System.out.println(LocalDateTime.now());
        System.out.println(itemCount);
    }
}
