import java.util.ArrayList;

public class Bt3 {
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
        int max =arrayList.getFirst();
        int min =arrayList.getFirst();
        for (int i = 0; i < arrayList.size(); i++) {
            if(arrayList.get(i)>max){
                max = arrayList.get(i);
            }else if(arrayList.get(i)<min){
                min = arrayList.get(i);
            }
        }
        System.out.println(max);
        System.out.println(min);
    }
}
