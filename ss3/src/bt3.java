import java.util.Scanner;

public class bt3 {
    public  static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập điểm trung bình của sinh viên ");
        float poin = sc.nextFloat();

        if (poin >8.5){
            System.out.println("giỏi");
        } else if (poin >=6.5) {
            System.out.println("khá");
        } else if (poin >=5.5) {
            System.out.println("trung bình");
        } else {
            System.out.println("yếu");
        }

        sc.close();
    }
}
