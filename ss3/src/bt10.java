import java.util.Scanner;

public class bt10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập hệ số a: ");
        double a = scanner.nextDouble();
        System.out.print("Nhập hệ số b: ");
        double b = scanner.nextDouble();
        System.out.print("Nhập hệ số c: ");
        double c = scanner.nextDouble();
        System.out.print("Nhập hệ số d: ");
        double d = scanner.nextDouble();

        if (a == 0) {
            solveQuadraticOrLinear(b, c, d);
        } else {
            solveCubic(a, b, c, d);
        }

        scanner.close();
    }

    private static void solveQuadraticOrLinear(double a, double b, double c) {
        if (a == 0) {
            if (b == 0) {
                System.out.println(c == 0 ? "Phương trình có vô số nghiệm" : "Phương trình vô nghiệm");
            } else {
                System.out.println("Nghiệm của phương trình: x = " + (-c / b));
            }
        } else {
            double delta = b * b - 4 * a * c;
            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                System.out.println("Nghiệm của phương trình: x1 = " + x1 + ", x2 = " + x2);
            } else if (delta == 0) {
                System.out.println("Phương trình có nghiệm kép: x = " + (-b / (2 * a)));
            } else {
                System.out.println("Phương trình vô nghiệm thực");
            }
        }
    }

    private static void solveCubic(double a, double b, double c, double d) {
        double p = (3 * a * c - b * b) / (3 * a * a);
        double q = (2 * b * b * b - 9 * a * b * c + 27 * a * a * d) / (27 * a * a * a);
        double delta = (q * q / 4) + (p * p * p / 27);

        if (delta > 0) {
            double u = Math.cbrt(-q / 2 + Math.sqrt(delta));
            double v = Math.cbrt(-q / 2 - Math.sqrt(delta));
            double x1 = u + v - b / (3 * a);
            System.out.println("Một nghiệm thực duy nhất: x = " + x1);
        } else if (delta == 0) {
            double x1 = 2 * Math.cbrt(-q / 2) - b / (3 * a);
            double x2 = -Math.cbrt(-q / 2) - b / (3 * a);
            System.out.println("Hai nghiệm phân biệt: x1 = " + x1 + ", x2 = " + x2);
        } else {
            double r = Math.sqrt(-p * p * p / 27);
            double phi = Math.acos(-q / (2 * r));
            double x1 = 2 * Math.cbrt(r) * Math.cos(phi / 3) - b / (3 * a);
            double x2 = 2 * Math.cbrt(r) * Math.cos((phi + 2 * Math.PI) / 3) - b / (3 * a);
            double x3 = 2 * Math.cbrt(r) * Math.cos((phi + 4 * Math.PI) / 3) - b / (3 * a);
            System.out.println("Ba nghiệm thực: x1 = " + x1 + ", x2 = " + x2 + ", x3 = " + x3);
        }
    }
}