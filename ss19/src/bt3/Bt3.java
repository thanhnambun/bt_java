package bt3;

import java.util.Scanner;

@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}

public class Bt3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Vui lòng nhập số nguyên a:");
        int a = sc.nextInt();
        System.out.println("Vui lòng nhập số nguyên b:");
        int b = sc.nextInt();


        MathOperation addOperation = MathOperations::add;
        MathOperation subtractOperation = MathOperations::subtract;
        MathOperation multiplyOperation = MathOperations::multiply;
        MathOperation divideOperation = MathOperations::divide;


        System.out.println("Tổng: " + addOperation.operate(a, b));
        System.out.println("Hiệu: " + subtractOperation.operate(a, b));
        System.out.println("Tích: " + multiplyOperation.operate(a, b));
        try {
            System.out.println("Thương: " + divideOperation.operate(a, b));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }


    }
}