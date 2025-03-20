import java.util.ArrayList;

public class Bt9 {
    public static boolean isCheck(int n){
        if (n <2) return false;
        for(int j = 2;j<=Math.sqrt(n);j++){
            if(n%j==0){
                return true;
            }
        }
        return false;
    }
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
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        ArrayList<Integer> arrayList3 = new ArrayList<>();
        for(int i = 0 ; i < arrayList.size() ; i++){
            if(isCheck(arrayList.get(i))){
                arrayList1.add(arrayList.get(i));
            }else {
                if (arrayList.get(i) % 2 == 0){
                    arrayList2.add(arrayList.get(i));
                }else if(arrayList.get(i) % 3 == 0){
                    arrayList3.add(arrayList.get(i));
                }
            }
        }
        System.out.println("số chẵn");
        for(Integer i : arrayList1){
            System.out.println(i);
        }
        System.out.println("số lẻ");
        for(Integer i : arrayList2){
            System.out.println(i);
        }
        System.out.println("số nguyên tố");
        for(Integer i : arrayList3){
            System.out.println(i);
        }
    }
}
