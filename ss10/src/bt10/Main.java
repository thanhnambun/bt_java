package bt10;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle("Hình tròn ", 52);
        shapes[1] = new Rectangle("Hình chữ nhật ", 14, 66);
        shapes[2] = new Triangle("Hình tam giác ", 31, 41, 5);


        System.out.println("----- Kiểm tra từng đối tượng -----");
        System.out.println("Diện tích hình tròn: " + shapes[0].calculateArea());
        System.out.println("Chu vi hình tròn: " + shapes[0].calculatePerimeter());
        System.out.println(shapes[0].toString());

        System.out.println("\nDiện tích hình chữ nhật: " + shapes[1].calculateArea());
        System.out.println("Chu vi hình chữ nhật: " + shapes[1].calculatePerimeter());
        System.out.println(shapes[1].toString());

        System.out.println("\nDiện tích hình tam giác: " + shapes[2].calculateArea());
        System.out.println("Chu vi hình tam giác: " + shapes[2].calculatePerimeter());
        System.out.println(shapes[2].toString());



        System.out.println("\n----- Danh sách các hình -----");
        for (int i = 0; i < shapes.length; i++) {
            System.out.println("---");
            System.out.println("Tên hình: " + shapes[i].getName());
            System.out.println("Diện tích: " + shapes[i].calculateArea());
            System.out.println("Chu vi: " + shapes[i].calculatePerimeter());
            System.out.println("Thông tin chi tiết: " + shapes[i].toString());
        }
    }
}