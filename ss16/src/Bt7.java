import java.util.ArrayList;

public class Bt7 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> a1 = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(81);
        arrayList.add(3);
        arrayList.add(15);
        int cout = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            cout = 0;
            if (!a.contains(arrayList.get(i))) {
                for (int j = 0; j < arrayList.size(); j++) {
                    if (arrayList.get(j).equals(arrayList.get(i))) {
                        cout++;
                    }
                }
            }
            a.add(arrayList.get(i));
            a1.add(cout);
        }
        System.out.println("phần tử xuất hiện 1 lần là ");
        for (int j = 0; j < a1.size(); j++) {
            if (a1.get(j) == 1) {
                System.out.printf(a.get(j)+ ", ");
            }
        }
        System.out.println("\n phần tử trùng lặp và số lần xuất hiện là ");
        for (int j = 0; j < a1.size(); j++) {
            if (a1.get(j) > 1) {
                System.out.println(a.get(j) + " xuất hiện " + a1.get(j) + " lần");
            }
        }
    }
}
