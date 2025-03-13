public class Book {
    private String title;
    private String author;
    private float price;

    public Book(String title, String author, float price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        if (price >0) {
            this.price = price;
        }else {
            System.out.println("giá không được âm");
        }
    }

    public static void main(String[] args) {
        Book book = new Book("những đứa trẻ hay khóc","nam",10);
        int newPrice =-10;
        book.setPrice(newPrice);
        System.out.println(book.getPrice());
    }
}
