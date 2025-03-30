import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bt6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] list = new int [10];
        int count = 0;
        List<Integer>  list1 = new ArrayList<>();
        System.out.println("vui lòng nhập danh sách ");
        for (int i = 0; i < list.length; i++) {
            try {
                list[i] =Integer.parseInt(sc.nextLine());
                list1.add(list[i]);
            }catch (Exception e){
                count++;
            }
        }
        System.out.println("số lượng chuỗi không hợp lệ laf " +count);
        System.out.println("số lượng chuỗi hợp lệ alf :" + list1.size());
        System.out.println(list1);
    }
}
