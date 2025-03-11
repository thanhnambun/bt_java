public class bt2 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello, Java World!");
        System.out.println(sb.toString());
        sb.delete(5,9);
        System.out.println(sb);
        sb.replace(8,13,"Universe");
        System.out.println(sb);
    }
}
