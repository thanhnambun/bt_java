import java.util.LinkedHashMap;
import java.util.Map;

public class Bt3 {
    public static void main(String[] args) {
        Map<String, Double> productList = new LinkedHashMap<>();
        productList.put("nam2",8.0);
        productList.put("nam3",8.0);
        productList.put("nam4",8.0);
        productList.put("nam5",8.0);
        productList.put("nam6",8.0);
        System.out.println(productList);
        productList.put("nam2",10.0);
        productList.remove("nam2");
        System.out.println(productList);
    }
}
