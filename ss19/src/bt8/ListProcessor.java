package bt8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public interface ListProcessor {
    default boolean checkOdd(List<Integer> list) {
        Predicate<Integer> isOdd = num -> num % 2 != 0;
        for (Integer num : list) {
            if (isOdd.test(num)) {
                return true;
            }
        }
        return false;
    }

    int sumOddNumbers(List<Integer> list);

    static void printList(List<Integer> list){
        System.out.println(list);
    }

}
