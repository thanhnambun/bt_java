package bt6;

public class MoveablePoint extends Point {
    double xSpeed;
    double ySpeed;
    public MoveablePoint(){

    }

    public MoveablePoint(double x, double y, double xSpeed, double ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public double getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(double xSpeed) {
        this.xSpeed = xSpeed;
    }

    public double getySpeed() {
        return ySpeed;
    }

    public void setySpeed(double ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void move() {
        double newX = this.getX() + xSpeed;
        double newY = this.getY() + ySpeed;
        this.setX(newX);
        this.setY(newY);
    }

    public String toString() {
       return "Move Point ("+getxSpeed()+","+getySpeed() + ")";
    }

}
