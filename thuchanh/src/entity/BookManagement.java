package entity;

import java.time.Year;
import java.util.Scanner;

public class BookManagement {
    static Book[] arrBook = new Book[100];
    static int currentIndex = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("*******************MENU*******************");
            System.out.println("1. Danh sách sách");
            System.out.println("2. Thêm mới sách");
            System.out.println("3. Tính lợi nhuận của các sách");
            System.out.println("4. Cập nhật sách");
            System.out.println("5. Xóa sách");
            System.out.println("6. Sắp xếp sách theo lợi nhuận tăng dần");
            System.out.println("7. Tìm kiếm sách theo tác giả");
            System.out.println("8. Tìm kiếm sách theo khoảng giá");
            System.out.println("9. Thống kê sách theo mỗi tác giả");
            System.out.println("10. Thoát");
            System.out.print("Vui lòng chọn: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    displayBook();
                    break;
                case 2:
                    addBook(sc);
                    break;
                case 3:
                    bookProfits();
                    break;
                case 4:
                    updateBook(sc);
                    break;
                case 5:
                    deleteBook(sc);
                    break;
                case 6:
                    sortBooksByProfit();
                    System.out.println("danh sách đãdducojuocw sắp xếp là:");
                    displayBook();
                    break;
                case 7:
                    searchBookByTitle(sc);
                    break;
                case 8:
                    searchBookByPrice(sc);
                    break;
                case 9:
                    statisticalBookbyAuthor(sc);
                    break;
                case 10:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn sai, vui lòng chọn lại.");
                    break;
            }
        } while (true);
    }

    public static void displayBook() {
        if (currentIndex == 0) {
            System.out.println("Danh sách sách đang trống.");
            return;
        }
        for (int i = 0; i < currentIndex; i++) {
            arrBook[i].display();
        }
    }

    public static void addBook(Scanner sc) {
        System.out.println("Vui lòng nhập số sách cần thêm:");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            arrBook[currentIndex] = new Book();
            arrBook[currentIndex].inputData(sc);
            currentIndex++;
        }
    }

    public static void bookProfits() {
        if (currentIndex == 0) {
            System.out.println("Chưa có sách để tính lợi nhuận.");
            return;
        }
        for (int i = 0; i < currentIndex; i++) {
            System.out.printf("Tên sách: %s , Lợi nhuận: %.2f%n", arrBook[i].getBookName(), arrBook[i].getInterest());
        }
    }

    public static void updateBook(Scanner sc) {
        System.out.println("Vui lòng nhập ID của cuốn sách cần sửa thông tin:");
        String id = sc.nextLine();

        int index = findBookById(id);
        if (index == -1) {
            System.out.println("Không tìm thấy sách với ID trên.");
            return;
        }

        Book book = arrBook[index];

        boolean isUpdating = true;
        while (isUpdating) {
            System.out.println("------ MENU SỬA THÔNG TIN ------");
            System.out.println("1. Sửa tên sách");
            System.out.println("2. Sửa giá nhập sách");
            System.out.println("3. Sửa giá bán sách");
            System.out.println("4. Sửa tiêu đề sách");
            System.out.println("5. Sửa tên tác giả");
            System.out.println("6. Sửa năm xuất bản");
            System.out.println("7. Thoát");
            System.out.print("Vui lòng chọn: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    do {
                        System.out.println("Nhập tên sách mới (6-100 ký tự):");
                        String newName = sc.nextLine();
                        if (newName.length() >= 6 && newName.length() <= 100) {
                            book.setBookName(newName);
                            System.out.println("Cập nhật tên sách thành công!");
                            break;
                        } else {
                            System.err.println("Tên sách không hợp lệ!");
                        }
                    } while (true);
                    break;

                case 2:
                    do {
                        System.out.println("Nhập giá nhập sách mới (> 0):");
                        float newImportPrice = sc.nextFloat();
                        sc.nextLine();
                        if (newImportPrice > 0) {
                            book.setImportPrice(newImportPrice);
                            System.out.println("Cập nhật giá nhập thành công!");
                            break;
                        } else {
                            System.err.println("Giá nhập phải lớn hơn 0!");
                        }
                    } while (true);
                    break;

                case 3:
                    do {
                        System.out.println("Nhập giá bán sách mới (>= 10% giá nhập):");
                        float newExportPrice = sc.nextFloat();
                        sc.nextLine();
                        if (newExportPrice >= book.getImportPrice() * 1.1) {
                            book.setExportPrice(newExportPrice);
                            System.out.println("Cập nhật giá bán thành công!");
                            break;
                        } else {
                            System.out.println("Giá bán quá thấp! Nhập lại hay không? (1.Có / 2.Không):");
                            int c = sc.nextInt();
                            sc.nextLine();
                            if (c == 2) break;
                        }
                    } while (true);
                    break;

                case 4:
                    do {
                        System.out.println("Nhập tiêu đề sách mới:");
                        String newTitle = sc.nextLine();
                        if (!newTitle.trim().isEmpty()) {
                            book.setTitle(newTitle);
                            System.out.println("Cập nhật tiêu đề thành công!");
                            break;
                        } else {
                            System.err.println("Tiêu đề không được để trống!");
                        }
                    } while (true);
                    break;

                case 5:
                    do {
                        System.out.println("Nhập tên tác giả mới:");
                        String newAuthor = sc.nextLine();
                        if (!newAuthor.trim().isEmpty()) {
                            book.setAuthor(newAuthor);
                            System.out.println("Cập nhật tên tác giả thành công!");
                            break;
                        } else {
                            System.err.println("Tên tác giả không được để trống!");
                        }
                    } while (true);
                    break;

                case 6:
                    do {
                        try {
                            System.out.println("Nhập năm xuất bản mới (> 1970):");
                            int newYear = Integer.parseInt(sc.nextLine());
                            if (newYear > 1970) {
                                book.setYear(Year.of(newYear));
                                System.out.println("Cập nhật năm xuất bản thành công!");
                                break;
                            } else {
                                System.err.println("Năm xuất bản phải lớn hơn 1970!");
                            }
                        } catch (NumberFormatException e) {
                            System.err.println("Vui lòng nhập đúng định dạng năm!");
                        }
                    } while (true);
                    break;

                case 7:
                    isUpdating = false;
                    System.out.println("Đã thoát chỉnh sửa sách.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;
            }

            book.setInterest(book.calInterest());
        }
    }

    public static int findBookById(String bookId) {
        for (int i = 0; i < currentIndex; i++) {
            if (arrBook[i].getBookId().equals(bookId)) {
                return i;
            }
        }
        return -1;
    }

    public static void deleteBook(Scanner sc) {
        System.out.println("Vui lòng nhập ID của cuốn sách cần xóa:");
        String deleteId = sc.nextLine();

        int indexDelete = findBookById(deleteId);
        if (indexDelete == -1) {
            System.out.println("Không tìm thấy sách với ID trên.");
        } else {
            for (int i = indexDelete; i < currentIndex - 1; i++) {
                arrBook[i] = arrBook[i + 1];
            }
            arrBook[currentIndex - 1] = null;
            currentIndex--;
            System.out.println("Đã xóa sách thành công!");
        }
    }

    public static void sortBooksByProfit() {
        for (int i = 0; i < currentIndex; i++) {
            for (int j = i + 1; j < currentIndex; j++) {
                if (arrBook[i].getInterest() > arrBook[j].getInterest()) {
                    Book temp = arrBook[i];
                    arrBook[i] = arrBook[j];
                    arrBook[j] = temp;
                }
            }
        }
    }

    public static void searchBookByTitle(Scanner sc) {
        System.out.println("vui lòng nhập tên tác giả cần tìm");
        String searchTitle = sc.nextLine();
        boolean check = true;
        for (int i = 0; i < arrBook.length; i++) {
            if (arrBook[i].getTitle().toLowerCase().contains(searchTitle.toLowerCase())) {
                arrBook[i].display();
                check = false;
            }
        }
        if (check) {
            System.err.println("không tìm thấy tác gải trên");
        }
    }

    public static void searchBookByPrice(Scanner sc) {
        System.out.println("vui lòng nhập giá sách (min,max)");
        float min = Float.parseFloat(sc.nextLine());
        float max = Float.parseFloat(sc.nextLine());
        for (int i = 0; i < arrBook.length; i++) {
            if (arrBook[i].getExportPrice() >= min && arrBook[i].getExportPrice() <= max) {
                arrBook[i].display();
            }
        }
    }

    public static void statisticalBookbyAuthor(Scanner sc) {
        String[] newAuthors = new String[currentIndex];
        for (int i = 0; i < currentIndex; i++) {
            for (int j = i + 1; j < currentIndex; j++) {
                if (arrBook[j].getAuthor().equals(newAuthors[i])) {
                    continue;
                }else{
                    newAuthors[i] = arrBook[j].getAuthor();
                }
            }
        }
        for (int i = 0; i < newAuthors.length; i++) {
            System.out.println(newAuthors[i]+ "có những cuốn sách sau : ");
            for (int j = 0; j < currentIndex; j++) {
                if (arrBook[j].getAuthor().equals(newAuthors[i])) {
                    System.out.println(arrBook[j].getBookName());
                }else {
                    System.out.println("tác giả này o có cuốn sacách nnafo");
                }
            }
        }
    }
}
