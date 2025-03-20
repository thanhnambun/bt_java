import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("a");
        if (!sc.hasNextInt()) {
            System.out.println("b");
        }else {
            System.out.println("c");
        }
    }
}