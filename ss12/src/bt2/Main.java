package bt2;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        int sumTwoNumbers = calculator.add(5, 10);
        System.out.println("Tổng của 2 số là: " + sumTwoNumbers);

        int sumThreeNumbers = calculator.add(3, 7, 9);
        System.out.println("Tổng của 3 số là: " + sumThreeNumbers);
    }
}

