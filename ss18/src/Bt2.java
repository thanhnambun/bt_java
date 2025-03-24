import java.util.HashMap;
import java.util.Map;

public class Bt2 {
    public static void main(String[] args) {
        Map<String,Integer> product = new HashMap<>();
        product.put("a",1);
        product.put("b",2);
        product.put("c",3);
        product.put("laptop",4);

        if (product.containsKey("laptop")){
            System.out.println("có tồn tại ");
        }else {
            System.out.println("không tồn tại");
        }
        System.out.println("có sản phẩm nào có giá trị bằng 1000 hay không :" +product.containsValue(1000));
    }
}
