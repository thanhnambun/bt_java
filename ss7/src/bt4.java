import java.util.Scanner;

public class bt4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập chuỗi : ");
        String str1 = sc.nextLine();
        StringBuilder sb1=new StringBuilder(str1);
        StringBuilder sb2 =sb1.reverse();
        boolean isEqual = sb1.toString().equals(sb2.toString());
        if(isEqual){
            System.out.println("chuỗi ddoosoois xứng ");
        }else {
            System.out.println("chuỗi không đối xứng");
        }
    }
}
