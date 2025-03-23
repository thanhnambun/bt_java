import java.util.*;

public class Bt9 implements Comparable<Bt9> {
    private String id;
    private String title;
    private String author;
    private int year;

    public Bt9(String id, String title, String author, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getYear() { return year; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bt9)) return false;
        Bt9 book = (Bt9) o;
        return id.equals(book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Bt9 o) {
        return this.title.compareTo(o.title);
    }

    @Override
    public String toString() {
        return "Book{" +
                "ID='" + id + '\'' +
                ", Title='" + title + '\'' +
                ", Author='" + author + '\'' +
                ", Year=" + year +
                '}';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Bt9> set = new HashSet<>();

        set.add(new Bt9("B001", "Java Programming", "Nguyen Van A", 2019));
        set.add(new Bt9("B002", "Data Structures", "Tran Van B", 2021));
        set.add(new Bt9("B003", "Database Systems", "Le Thi C", 2018));
        set.add(new Bt9("B004", "Algorithms", "Pham Van D", 2020));
        set.add(new Bt9("B005", "Computer Networks", "Hoang Van E", 2022));
        // Thêm trùng ID để test xem có vào được không
        set.add(new Bt9("B001", "Duplicate Book", "Some Author", 2025));

        System.out.println("Danh sách sách trong set:");
        for (Bt9 book : set) {
            System.out.println(book);
        }

        System.out.println("\nVui lòng nhập năm xuất bản để lọc sách:");
        int year = sc.nextInt();

        List<Bt9> list = new ArrayList<>();
        for (Bt9 book : set) {
            if (book.getYear() > year) {
                list.add(book);
            }
        }

        Collections.sort(list);

        System.out.println("\nDanh sách sách xuất bản sau năm " + year + " (đã sắp xếp theo tên):");
        for (Bt9 book : list) {
            System.out.println(book);
        }

        sc.close();
    }
}
