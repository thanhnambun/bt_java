import java.util.LinkedHashMap;
import java.util.Map;

public class Bt6 {
    public static void main(String[] args) {
        Map<String,Double> std = new LinkedHashMap<>();
        std.put("nv121", 10.0);
        std.put("nv122", 20.0);
        std.put("nv123", 30.0);
        std.put("nv124", 40.0);
        std.put("nv125", 50.0);
        std.put("nv126", 60.0);
        std.put("nv127", 70.0);
        std.put("nv128", 80.0);
        std.put("nv129", 90.0);
        std.put("nv113", 100.0);
        System.out.println(std);
        double sum = 0.0;
        for(Map.Entry<String,Double> entry:std.entrySet()){
            sum+=entry.getValue();
        }
        System.out.println("điểm trung bình của taast cả học sinh " + sum/std.size());
        for(Map.Entry<String,Double> entry:std.entrySet()){
            if(entry.getValue()<50){
                std.remove(entry);
            }
        }
    }
}
