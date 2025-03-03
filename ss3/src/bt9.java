import java.util.Scanner;

public class bt9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("vui lòng nhập số từ 100 - 999");
        int a =sc.nextInt();

        if (a<100 && a>999) {
            System.out.println("số không đúng định dạng");
            return ;
        }

        int hundreds = a/100;
        int tens = a/10%10;
        int units = a%10;

        switch(hundreds){
            case 1 -> System.out.print("một trăm");
            case 2 -> System.out.print("hai trăm");
            case 3 -> System.out.print("ba trăm");
            case 4 -> System.out.print("bốn trăm");
            case 5 -> System.out.print("năm trăm");
            case 6 -> System.out.print("sáu trăm");
            case 7 -> System.out.print("bảy trăm");
            case 8 -> System.out.print("tám trăm");
            case 9 -> System.out.print("chín trăm");
        }
        if (tens > 0 || units > 0) {
            System.out.print(" ");
            switch (tens) {
                case 0 -> System.out.print("lẻ");
                case 1 -> System.out.print("mười");
                case 2 -> System.out.print("hai mươi");
                case 3 -> System.out.print("ba mươi");
                case 4 -> System.out.print("bốn mươi");
                case 5 -> System.out.print("năm mươi");
                case 6 -> System.out.print("sáu mươi");
                case 7 -> System.out.print("bảy mươi");
                case 8 -> System.out.print("tám mươi");
                case 9 -> System.out.print("chín mươi");
            }
        }
        if (units > 0) {
            System.out.print(" ");
            switch (units) {
                case 1 -> System.out.print("một");
                case 2 -> System.out.print("hai");
                case 3 -> System.out.print("ba");
                case 4 -> System.out.print("bốn");
                case 5 -> System.out.print("năm");
                case 6 -> System.out.print("sáu");
                case 7 -> System.out.print("bảy");
                case 8 -> System.out.print("tám");
                case 9 -> System.out.print("chín");
            }
        }

        sc.close();
    }
}
