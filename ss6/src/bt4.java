import java.util.Scanner;

public class bt4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String result = str.replaceAll("[0-9]", "*");
        System.out.println(result);
    }
}