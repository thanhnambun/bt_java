import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Bt5 {
    public static void main(String[] args) {
        Set<Integer> setHashSet = new HashSet<Integer>();
        Set<Integer> setHashSet2 = new HashSet<Integer>();
        setHashSet.add(1);
        setHashSet.add(2);
        setHashSet.add(3);
        setHashSet.add(4);
        setHashSet.add(5);
        setHashSet2.add(6);
        setHashSet2.add(7);
        setHashSet2.add(8);
        setHashSet2.add(9);
        setHashSet2.add(10);
        Set<Integer> mergedSet = new TreeSet<>(setHashSet);
        mergedSet.addAll(setHashSet2);
        System.out.println(mergedSet);
    }
}
