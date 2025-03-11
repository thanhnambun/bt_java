public class Point2D {
    private double x;
    private double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    public double distanceTo(Point2D p) {
        return Math.sqrt(Math.pow(p.x - this.x, 2) + Math.pow(p.y - this.y, 2));
    }
    public void displayPoint(){
        System.out.println("(" +this.x+","+this.y+")");
    }

    public static void main(String[] args) {
        Point2D p1 = new Point2D(5,10);
        Point2D p2 = new Point2D(2,8);
        p1.displayPoint();
        p2.displayPoint();
        System.out.println(" khoảng cách giữa 2 điểm là "+p1.distanceTo(p2));
    }
}
