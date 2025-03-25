package bt4;

public class Circle implements Shape {
    private double radius;
    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        Circle circle = new Circle(5);
        System.out.println(circle.area());
        Shape.description();
    }
}
