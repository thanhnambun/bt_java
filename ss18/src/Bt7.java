import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bt7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =0 ;
        System.out.println("vui lòng nhập số phần tử trong mảng ");
        n=Integer.parseInt(sc.nextLine());
        int [] arr = new int [n];
        System.out.println("vui lòng nhập giá trị phần tử trong mảng ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(sc.nextLine());
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i],null);
        }
        int count  ;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            count=0;
            for (int i = 0; i < n; i++) {
                if(arr[i] == entry.getKey()){
                    count++;
                }
            }
            entry.setValue(count);
        }
        System.out.println(map);
    }
}
