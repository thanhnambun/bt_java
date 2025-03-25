import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bt5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> arrString = new ArrayList<>();
        arrString.add("Alice");
        arrString.add("Bob");
        arrString.add("Andrew");
        arrString.add("Anna");
        arrString.add("Charles");
        int count = 0;
        for (String a:arrString){
            if(a.charAt(0)=='A'){
                count++;
            }
        }
        System.out.println(count);
    }
}
