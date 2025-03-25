import java.util.function.Function;
import java.util.function.Supplier;

public class Bt2 {
    public static void main(String[] args) {
        Function<Integer,Integer> f= x->x*x +3*x+2;
        System.out.println(f.apply(3));;
    }
}
