import java.util.Scanner;

public class bt4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=0;
        int sum=0;
        while(true){
            System.out.println("vui lòng nhập số");
            n=Integer.parseInt(sc.nextLine());
            if(n==0){
                break;
            }
            sum += n;
        }
        System.out.printf("tổng của các số đã nhập là %d" ,sum);
    }
}
