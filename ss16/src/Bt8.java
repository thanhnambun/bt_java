import java.util.ArrayList;

public class Bt8 {
    public static void main(String[] args) {
        ArrayList<String> stringArr = new ArrayList<String>();
        stringArr.add("nam");
        stringArr.add("surname");
        stringArr.add("pat");
        stringArr.add("nguyen");
        stringArr.add("chip");
        stringArr.add("quinn");
        for (int i = 0; i < stringArr.size(); i++) {
            for (int j = i+1; j < stringArr.size(); j++) {
                if (stringArr.get(i).length() > stringArr.get(j).length() ) {
                    String temp = stringArr.get(i);
                    stringArr.set(i, stringArr.get(j));
                    stringArr.set(j, temp);
                }else if (stringArr.get(i).length() == stringArr.get(j).length()) {
                    if(stringArr.get(i).compareTo(stringArr.get(j)) >0) {
                        String temp = stringArr.get(i);
                        stringArr.set(i, stringArr.get(j));
                        stringArr.set(j, temp);
                    }
                }
            }
        }
        for(String s: stringArr) {
            System.out.println(s);
        }
    }
}
