package bt7;

import java.util.List;

public interface ListProcessor {
    default void printList(List<Integer> list){
        System.out.println(list);
    }
    void containsNegative(List<Integer> list);
}
