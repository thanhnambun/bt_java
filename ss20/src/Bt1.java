import java.util.ArrayList;
import java.util.List;

public class Bt1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        list.stream().filter(x->x % 2 == 0).forEach(System.out::println);

    }
}
