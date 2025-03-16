package bt4;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);

        System.out.println("Diện tích hình tròn (Overriding): " + circle.area());
        System.out.println("Diện tích hình chữ nhật (Overriding): " + rectangle.area());

        Shape shape = new Shape();

        System.out.println("Diện tích hình tròn : " + shape.area(7));
        System.out.println("Diện tích hình chữ nhật : " + shape.area(3, 8));
    }
}
