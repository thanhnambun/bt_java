package presentation;

import entity.Book;
import java.util.ArrayList;
import java.util.Scanner;
import bussiness.BookBusiness;

public class BookApplication {
    public static ArrayList<Book> bookArrayList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nBook Menu");
            System.out.println("1. Hiển thị danh sách các cuốn sách");
            System.out.println("2. Thêm mới sách");
            System.out.println("3. Chỉnh sửa thông tin sách");
            System.out.println("4. Xóa sách");
            System.out.println("5. Tìm kiếm sách");
            System.out.println("6. Sắp xếp");
            System.out.println("0. Thoát chương trình");
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    BookBusiness.displayBooks();
                    break;
                case 2:
                    BookBusiness.addBooks(sc);
                    break;
                case 3:
                    BookBusiness.updateBook(sc);
                    break;
                case 4:
                    BookBusiness.removeBooks(sc);
                    break;
                case 5:
                    BookBusiness.searchBook(sc);
                    break;
                case 6:
                    BookBusiness.sortBooks(sc);
                    break;
                case 0:
                    System.out.println("Thoát chương trình...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);
    }
}
