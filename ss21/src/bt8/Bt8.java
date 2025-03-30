package bt8;

import java.util.Scanner;

public class Bt8  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("vui lòng nhập chuỗi số ddienj thoại");
        String nhap = sc.nextLine();
        String[] n = nhap.split(",");
        for (int i =0;i<n.length;i++){
            try{
            InvalidPhoneNumberLengthException.validatePhoneNumber(n[i]);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

}
