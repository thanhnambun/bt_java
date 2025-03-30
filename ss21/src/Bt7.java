import java.util.Scanner;

public class Bt7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double balance =1000000.00;
        System.out.println("vui lòng nhập số tền cần rút ");
        try{
            double price =Double.parseDouble(sc.nextLine());
            if (balance > 50000.00){
                if (price>balance){
                    System.out.println("số tiền cần rút lớn hơn số tiền trong tài khoarn");
                }
                balance =balance-price;
                System.out.println("rút tiền thành công");
            }System.err.println("Lỗi: Tài khoản phải duy trì số dư tối thiểu 50.000 đồng");
        }catch (Exception e){
            System.out.println("vui lòng nhập số hợp lệ");
        }
    }
}
