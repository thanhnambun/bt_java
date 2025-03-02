public class bt3 {
    public static void main(String[] args) {
        int a =10;
        int b = 5;
        boolean isEqual = (a == b);
        boolean isEqual2 = (a != b);
        boolean isEqual3 = (a > b);
        boolean isEqual4 = (a < b);
        boolean isEqual5 = (a >= b);
        boolean isEqual6 = (a <= b);
        System.out.println(" kết quả của các phép ss ");
        System.out.printf("a == b",isEqual);
        System.out.printf("a != b",isEqual2);
        System.out.printf("a > b",isEqual3);
        System.out.printf("a < b",isEqual4);
        System.out.printf("a >= b",isEqual5);
        System.out.printf("a <= b",isEqual6);
        if (a > b) {
            System.out.println("x lớn hơn y");
        } else if (a == b) {
            System.out.println("x bằng y");
        } else {
            System.out.println("x nhỏ hơn y");
        }
        double num = 10.5;
        String text = "10.5";

//        System.out.println(num == text);

    }
}
