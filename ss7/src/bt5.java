import java.util.Scanner;

public class bt5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập chuỗi : ");
        String str1 = sc.nextLine();
        String[]  str2 =str1.split(" ");

        StringBuilder sb = new StringBuilder();
        for(int i=str2.length-1;i>=0;i--){
            sb.append(str2[i]);
            if (i != 0){
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}
