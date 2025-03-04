import java.util.Scanner;

public class bt2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("vui lòng nhập số");
        int num =Integer.parseInt(sc.nextLine());
        if(num<2){
            System.out.println("Không phải số nguyên tố");
        }else {
            for(int i=2;i<=Math.sqrt(num);i++){
                if(num%i==0){
                    System.out.printf(" %d không phải số nguyên tố",num);
                    break;
                }
            }
            System.out.println(num + " là số nguyên tố");
        }
    }
}
