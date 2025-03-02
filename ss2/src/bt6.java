import java.util.Scanner;

public class bt6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("vui lòng nhập tên sinh viên");
        String name_student = sc.nextLine();
        System.out.println("vui lòng nhập lần lượt điểm của môn toán , lý , hóa ");
        double toan=sc.nextDouble();
        double ly = sc.nextDouble();
        double hoa = sc.nextDouble();

        double avg_diem = (toan+ly+hoa)/3;
        if(avg_diem>=8){
            System.out.println("giỏi");
        } else if (avg_diem>=6.5) {
            System.out.println("khá");
        } else if (avg_diem>=5.5) {
            System.out.println("trung bình");
        }else {
            System.out.println("yếu");
        }
        sc.close();
    }
}
