import java.util.ArrayList;

public class Bt5 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> a= new ArrayList<>();
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
        int cout =0 ;
        for(int i = 0 ; i < arrayList.size() ; i++){
            cout =0 ;
            if(!a.contains(arrayList.get(i))){
                for(int j = 0 ; j < arrayList.size() ; j++){
                    if(arrayList.get(j).equals(arrayList.get(i))){
                        cout ++;
                    }
                }
            }
            System.out.println(arrayList.get(i) + " xuất hiện " + cout + " lần");
            a.add(arrayList.get(i));
        }
    }
}
