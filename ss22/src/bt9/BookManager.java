package bt9;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private List<Book> books;
    private final String fileName = "books.dat";

    public BookManager() {
        books = readBooksFromFile();
    }


    public void addBook(Book book) {
        books.add(book);
        saveBooksToFile();
    }
    public void updateBook(Book book) {
        for (Book b : books) {
            if (b.getId() == book.getId()) {
                b.setName(book.getName());
                b.setAuthor(book.getAuthor());
                b.setPublisher(book.getPublisher());
                b.setPrice(book.getPrice());
                saveBooksToFile();
                return;
            }
        }
        System.out.println("Không tìm thấy sách có ID: " + book.getId());
    }

    public void deleteBook(int id) {
        books.removeIf(b -> b.getId() == id);
        saveBooksToFile();
    }

    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("Danh sách sách trống.");
        } else {
            books.forEach(System.out::println);
        }
    }

    private void saveBooksToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(books);
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    private List<Book> readBooksFromFile() {
        File file = new File(fileName);
        if (!file.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<Book>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        BookManager manager = new BookManager();
        manager.addBook(new Book(1, "Java Programming", "James Gosling", "Tech Press", 250000));
        manager.addBook(new Book(2, "Data Structures", "Robert Lafore", "Pearson", 300000));
        manager.displayAllBooks();
        System.out.println("Cập nhật sách...");
        manager.updateBook(new Book(1, "Advanced Java", "James Gosling", "Tech Press", 280000));
        ;
        manager.displayAllBooks();
        System.out.println("Xóa sách có ID = 2...");
        manager.deleteBook(2);
        manager.displayAllBooks();
    }
}



