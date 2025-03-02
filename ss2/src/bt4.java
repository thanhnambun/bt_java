public class bt4 {
    public static void main(String[] args) {

        boolean a = true;
        boolean b = false;
        boolean c = true;

        if (a && b) {
            System.out.println("Cả hai đều đúng");
        } else {
            System.out.println("Cả hai không đúng");
        }

        if (a || b) {
            System.out.println("Ít nhất một đúng");
        }

        if (!a && b) {
            System.out.println("Không đúng (a sai, b đúng)");
        }

        System.out.println("Giá trị ban đầu của c: " + c);
        c = !c;
        System.out.println("Giá trị sau khi đảo ngược của c: " + c);

        if ((a || b) && !c) {
            System.out.println("Điều kiện kết hợp đúng");
        } else {
            System.out.println("Điều kiện kết hợp sai");
        }
    }
}
