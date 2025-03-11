public class Vector2D {
    private double x;
    private double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double calculateMagnitude() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }

    public Vector2D  add(Vector2D v) {
        double newV = this.x + v.x;
        double newV2 = this.y + v.y;
        return new Vector2D(newV,newV2);
    }
    public Vector2D  subtract(Vector2D v) {
        double newV = v.x- this.x;
        double newV2 = v.y- this.y;
        return new Vector2D(newV,newV2);
    }
    public Vector2D  dotProduct(Vector2D v) {
        return new Vector2D(this.x*v.x,this.y*v.y);
    }
    public void display() {
        System.out.printf("%f %f\n",this.x,this.y);
    }

    public static void main(String[] args) {
        Vector2D v1 = new Vector2D(1,2);
        v1.display();
        Vector2D v2 = new Vector2D(3,4);
        v2.display();
        System.out.println("độ dài của vector 1 là "+v1.calculateMagnitude());
        System.out.println("độ dài của vector 2 là "+v2.calculateMagnitude());
        System.out.println("tổng là " + v1.add(v2) );
        System.out.println("hiệu là " + v1.subtract(v2) );
        System.out.println("tích là " + v1.dotProduct(v2));
    }
}
