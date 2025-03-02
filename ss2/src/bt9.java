import java.util.Scanner;

public class bt9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập cạnh a: ");
        double a = sc.nextDouble();
        System.out.println("Nhập cạnh b: ");
        double b = sc.nextDouble();
        System.out.println("Nhập cạnh c: ");
        double c = sc.nextDouble();

        double perimeter = a + b + c;

        double s = perimeter / 2;

        double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));

        System.out.println("\n---- Kết quả ----");
        System.out.println("Chu vi tam giác: " + perimeter);
        System.out.printf("Diện tích tam giác: %.2f\n", area);

        sc.close();

    }
}
