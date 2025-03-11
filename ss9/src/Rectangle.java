public class Rectangle {
    private  double width;
    private double height;

    public Rectangle() {
        this.height = 1;
        this.width = 1;
    }

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double getArea() {
        return width*height;
    }

    public double getPerimeter() {
        return (width+height)*2;
    }

    public void display() {
        System.out.printf(
                "Chiều dài là: %.2f, Chiều rộng là: %.2f, Chu vi là: %.2f, Diện tích là: %.2f\n",
                height, width, getPerimeter(), getArea()
        );
    }

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        r1.display();
        Rectangle r2 = new Rectangle(5,6);
        r2.display();
    }
}
