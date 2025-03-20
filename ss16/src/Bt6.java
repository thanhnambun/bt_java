import java.util.ArrayList;

public class Bt6 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(81);
        arrayList.add(6);
        arrayList.add(5);
        for (int i = arrayList.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arrayList.get(j).equals(arrayList.get(i))) {
                    arrayList.remove(i);
                    break;
                }
            }
        }
        for (Integer i : arrayList) {
            System.out.println(i);
        }
    }
}
