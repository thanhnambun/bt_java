import java.util.ArrayList;

public class Bt4 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);
        arrayList.add(81);
        arrayList.add(9);
        arrayList.add(15);
        int sum =0 ;
        for (int i = 0; i < arrayList.size(); i++) {
            sum +=arrayList.get(i);
        }
        System.out.println(sum);
    }
}
