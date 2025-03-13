public class Fraction {
    private int numerator;
    private int denominator;
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Mẫu số không được bằng 0");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    public Fraction add(Fraction other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        Fraction result = new Fraction(newNumerator, newDenominator);
        return result;
    }

    public Fraction subtract(Fraction other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        Fraction result = new Fraction(newNumerator, newDenominator);

        return result;
    }

    public Fraction multiply(Fraction other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        Fraction result = new Fraction(newNumerator, newDenominator);
        return result;
    }

    public Fraction divide(Fraction other) {
        if (other.numerator == 0) {
            throw new IllegalArgumentException("Không thể chia cho phân số có tử số bằng 0");
        }
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        Fraction result = new Fraction(newNumerator, newDenominator);
        result.simplify();
        return result;
    }

    private void simplify() {
        int gcd = findGCD(Math.abs(numerator), Math.abs(denominator));
        numerator /= gcd;
        denominator /=gcd;
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    private int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public String toString() {
        if (denominator == 1) {
            return String.valueOf(numerator);
        }
        return numerator + "/" + denominator;
    }

    public static void main(String[] args) {
        Fraction f1 = new Fraction(1, 2); // 1/2
        Fraction f2 = new Fraction(3, 4); // 3/4

        System.out.println("tổng 2 phân số " + f1.add(f2));

        System.out.println("hiệu 2 phân số là  " + f1.subtract(f2));

        System.out.println("tích 2 phân số là " + f1.multiply(f2));

        System.out.println("thương 2 phân số là " + f1.divide(f2));
    }
}
