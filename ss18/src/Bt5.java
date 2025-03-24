import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bt5 {
    public static void main(String[] args) {
        Map<String,Double> productMap = new HashMap<>();
        productMap.put("Laptop", 1400.0);
        productMap.put("Smartphone", 900.0);
        productMap.put("Tablet", 600.0);
        productMap.put("Monitor", 300.0);
        productMap.put("Keyboard", 100.0);
        productMap.put("Headphones", 500.0);
        productMap.put("Mouse", 50.0);
        productMap.put("Smartwatch", 800.0);

        List<Map.Entry<String,Double>> list = new ArrayList<>();

        for (Map.Entry<String,Double> entry : productMap.entrySet()) {
            if (entry.getValue()>500 && entry.getValue()<1500) {
                list.add(entry);
            }
        }
        list.sort((o1, o2) -> o1.getKey().compareTo(o2.getKey()));
        System.out.println(list);
    }
}
