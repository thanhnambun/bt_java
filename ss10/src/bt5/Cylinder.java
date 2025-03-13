package bt5;

public class Cylinder extends Circle {
    private double height;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double getVolume() {
        return super.getArea() * height;
    }

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }
}
