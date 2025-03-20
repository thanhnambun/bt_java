import java.util.ArrayList;

public class Bt2 {
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
        System.out.println("danh sách trc khi xóa ");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            if (arrayList.get(i) % 3 == 0) {
                arrayList.remove(i);
            }
        }

        System.out.println("Danh sách sau khi xóa");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }
}
