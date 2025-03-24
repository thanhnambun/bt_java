import java.util.HashMap;
import java.util.Map;

public class Bt1 {
    public static void main(String[] args) {
        Map<String,Double> stdList = new HashMap<>();
        stdList.put("nguyễn văn a ",10.0);
        stdList.put("nam",8.0);
        stdList.put("nam1",8.0);
        stdList.put("nam2",8.0);
        stdList.put("nam3",8.0);
        System.out.println(stdList.get("nam"));
    }
}
