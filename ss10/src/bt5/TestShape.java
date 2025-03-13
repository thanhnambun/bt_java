package bt5;

public class TestShape {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder(20, 20);
        Circle circle = new Circle(20);
        System.out.println("dien tích hình tròn là :"+ circle.getArea());
        System.out.println("thể tích hình cauaff là "+cylinder.getVolume());
        double newR = 23;
        double newC = 23;
        cylinder.setRadius(newR);
        System.out.println("thể tích hình cauaff sau khi thayddoori r là "+cylinder.getVolume());
        circle.setRadius(newC);
        System.out.println("dien tích hình tròn sau khi đổi r  là :"+ circle.getArea());
        System.out.println("thể tích hình cauaff sau khi thayddoori c là "+cylinder.getVolume());
    }
}
