import java.util.*;

public class Bt7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("vui lòng nhập chuỗi ");
        String a = sc.nextLine();
        String[] words = a.toLowerCase().split("\\W+");
        Set<String> uniqueWords = new HashSet<>();
        Collections.addAll(uniqueWords, words);
        List<String> wordList = new ArrayList<>();
        Collections.addAll(wordList, words);
        Collections.sort(wordList);
        int count ;
        for(String word:uniqueWords){
             count = 0;
            for (String w : wordList) {
                if (word.equals(w)) {
                    count++;
                }
            }
            System.out.println(word + ": " + count);
        }
    }
}
