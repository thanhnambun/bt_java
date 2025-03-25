package bt7;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Bt7 implements ListProcessor {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Bt7 bt7 = new Bt7();
        bt7.containsNegative(list);
        bt7.printList(list);
    }

    @Override
    public void containsNegative(List<Integer> list) {
        boolean ischeck = true;
        Predicate<Integer> check = x -> x < 0;
        for (Integer i : list) {
            if (check.test(i)) {
                ischeck = false;
            }
        }
        if (ischeck) {
            System.out.println("Danh sách chứa o số âm");
        } else {
            System.out.println("Danh sách chứa số âm");
        }
    }
}
