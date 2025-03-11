public class Circle {
    private double radius;
    public Circle() {
        this.radius = 1.0;
    }
    public Circle(double radius) {
        this.radius = radius;
    }
    public double getArea() {
        return this.radius * this.radius* Math.PI;
    }
    public double getCircumference() {
        return 2*Math.PI * this.radius;
    }
    public void display() {
        System.out.printf("bán kính là : %2f , diện tích là %2f, chu vi là %2f \n",radius,getArea(),getCircumference());
    }

    public static void main(String[] args) {
        Circle c1 = new Circle();
        c1.display();
        Circle c2 = new Circle();
        c2.display();
    }
}
