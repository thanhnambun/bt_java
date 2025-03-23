import java.util.*;

public class Bt8 implements Comparable<Bt8> {
    private int a;
    private int b;

    public Bt8(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Bt8 other) {
        if (this.a != other.a) {
            return Integer.compare(this.a, other.a);
        } else {
            return Integer.compare(this.b, other.b);
        }
    }

    @Override
    public String toString() {
        return "(" + a + ", " + b + ")";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> arr = new HashSet<>();
        List<Bt8> list = new ArrayList<>();

        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);

        System.out.println("Vui lòng nhập tổng 2 số:");
        int sum = sc.nextInt();

        Set<String> existedPairs = new HashSet<>();

        for (int i : arr) {
            for (int j : arr) {
                if (i + j == sum) {
                    String key = Math.min(i, j) + ":" + Math.max(i, j);
                    if (!existedPairs.contains(key)) {
                        list.add(new Bt8(i, j));
                        existedPairs.add(key);
                    }
                }
            }
        }

        Collections.sort(list);

        if (list.isEmpty()) {
            System.out.println("Không có cặp nào thỏa mãn.");
        } else {
            System.out.println("Các cặp số có tổng bằng " + sum + ":");
            for (Bt8 pair : list) {
                System.out.println(pair);
            }
        }
    }
}
