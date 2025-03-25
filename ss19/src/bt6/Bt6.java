package bt6;

import java.util.ArrayList;
import java.util.List;

interface StringProcessor {
    String processString(String str);
    default void printList(List<String> list){
        for(String a:list){
            System.out.println(a);
        }
    }

}
public class Bt6 {
    public static void main(String[] args) {
        List<String>  list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        StringProcessor processor = input -> input.toUpperCase() + " - TECHNICAL";
        for(String a:list){
            list2.add(processor.processString(a));
        }
       processor.printList(list2);
    }
}
