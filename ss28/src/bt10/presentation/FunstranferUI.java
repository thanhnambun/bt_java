package bt10.presentation;

import bt10.business.service.funsTransfer.FunsTranferServicImp;
import bt10.business.service.funsTransfer.FunsTransferService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FunstranferUI {
    public static void displayFundsTransferMenu(Scanner scanner){
        FunsTranferServicImp funsT = new FunsTranferServicImp();
        do {
            System.out.println("*****************FT MENU***************");
            System.out.println("1. Lịch sử giao dịch");
            System.out.println("2. Thống kê số tiền chuyển trong khoảng từ ngày đến ngày");
            System.out.println("3. Thống kê số tiền nhận theo tài khoản");
            System.out.println("4. Thống kê số giao dịch thành công từ ngày đến ngày");
            System.out.println("5. Thoát");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    displayfun(funsT);
                    break;
                case 2:
                    getTotalTransferredBetweenDates(funsT);
                    break;
                case 3:
                    getTotalReceivedByAccount(scanner,funsT);
                    break;
                case 4:
                    getCountTransfer(scanner,funsT);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("vui lòng nhập từ 1 đén 5");
                    break;
            }
        }while (true);
    }
    public static void displayfun(FunsTranferServicImp funsT){
        funsT.getTransferHistory();
    }
    public static void getTotalTransferredBetweenDates(FunsTranferServicImp funsT){
        Scanner scanner = new Scanner(System.in);
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            System.out.print("Vui lòng nhập ngày bắt đầu (yyyy-MM-dd): ");
            String fromDateStr = scanner.nextLine();
            System.out.print("Vui lòng nhập ngày kết thúc (yyyy-MM-dd): ");
            String toDateStr = scanner.nextLine();

             Date fromDate = sdf.parse(fromDateStr);
             Date toDate = sdf.parse(toDateStr);

            double total = funsT.getTotalTransferredBetweenDates(new java.sql.Date(fromDate.getTime()), new java.sql.Date(toDate.getTime()));
            System.out.println("Tổng tiền đã chuyển từ " + fromDateStr + " đến " + toDateStr + " là: " + total);
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
    public static void getTotalReceivedByAccount (Scanner sc ,  FunsTranferServicImp funsT){
        System.out.println("vui lòng nhập mã tài khoản");
        int id = Integer.parseInt(sc.nextLine());
        funsT.getTotalReceivedByAccount(id);
    }
    public static void getCountTransfer(Scanner sc ,  FunsTranferServicImp funsT){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            System.out.print("Vui lòng nhập ngày bắt đầu (yyyy-MM-dd): ");
            String fromDateStr = sc.nextLine();
            System.out.print("Vui lòng nhập ngày kết thúc (yyyy-MM-dd): ");
            String toDateStr = sc.nextLine();

            Date fromDate = sdf.parse(fromDateStr);
            Date toDate = sdf.parse(toDateStr);

            int count = funsT.getCountTransfer(new java.sql.Date(fromDate.getTime()), new java.sql.Date(toDate.getTime()));
            System.out.println("Tổng tiền đã chuyển từ " + fromDateStr + " đến " + toDateStr + " là: " + count);
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}
