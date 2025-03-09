import java.util.Scanner;

public class bt3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String word = sc.nextLine();
        int index = str.indexOf(word);
        if (index == -1) {
            System.out.println("tu khong xuat hien");
        } else {
            System.out.println("tu "+ word + "xuat hien o vi tri thu " + index + " trong chuoi" );
        }
    }
}