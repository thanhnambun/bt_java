package bt10;

public class Circle extends Shape {
    private double radius;
    private static final double PI = Math.PI;

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * PI * radius;
    }

    @Override
    public String toString() {
        return "Hình tròn - " + super.getName() + ", Bán kính: " + radius + ", Diện tích: " + calculateArea() + ", Chu vi: " + calculatePerimeter();
    }
}