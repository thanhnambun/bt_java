import java.time.LocalDate;
import java.util.Scanner;

public class bt8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("---- nhập thông tin sinh viên ---------");
        System.out.println("nhập mã sinh viên ");
        String id_st = sc.nextLine();
        System.out.println("nhập tên sinh viên");
        String name_st = sc.nextLine();
        System.out.println("nhập số điện thoai");
        String phone_st = sc.nextLine();
        System.out.println("nập ngày sinh ");
        int date_st = sc.nextInt();
        System.out.println("nhập giới tính (1: nam , 2 nữ )");
        int name_gender = sc.nextInt();

        System.out.println("---- nhập điểm sinh viên ---------");
        System.out.println(" nhập đểm toán ");
        float toan = sc.nextFloat();
        System.out.println(" nhập đểm ly ");
        float ly = sc.nextFloat();
        System.out.println(" nhập đểm hóa ");
        float hoa = sc.nextFloat();
        System.out.println(" nhập đểm sinh học ");
        float sinh_hoc = sc.nextFloat();
        System.out.println(" nhập đểm ngoại ngữ ");
        float ngoai_ngu = sc.nextFloat();

        float avg_diem= (toan + ly + hoa+sinh_hoc + ngoai_ngu)/5;

        System.out.println("\n---- Thông tin sinh viên ---------");
        System.out.println("Mã sinh viên: " + id_st);
        System.out.println("Tên sinh viên: " + name_st);
        System.out.println("Số điện thoại: " + phone_st);
        System.out.println("Ngày sinh: " + date_st);
        System.out.println("Giới tính: " + name_gender);
        System.out.print("Điểm Toán: " + toan);
        System.out.print("Điểm Lý: " + ly);
        System.out.print("Điểm Hóa: " + hoa);
        System.out.print("Điểm Sinh học: " + sinh_hoc);
        System.out.println("Điểm Ngoại ngữ: " + ngoai_ngu);
        System.out.printf("Điểm trung bình: %.2f\n", avg_diem);

        sc.close();

    }

}