package bt8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Bt8 implements ListProcessor {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(4);
        numbers.add(3);
        numbers.add(7);
        numbers.add(8);
        ListProcessor.printList(numbers);
        ListProcessor processor = new Bt8();
        System.out.println(processor.sumOddNumbers(numbers));;
        if(processor.checkOdd(numbers)){
            System.out.println("khoong co phan tu le");
        }
    }
    @Override
    public int sumOddNumbers(List<Integer> list) {
        Predicate<Integer> isOdd = num -> num % 2 != 0;
        int sum = 0;
        for (Integer num : list) {
            if (isOdd.test(num)) {
                sum += num;
            }
        }
        return sum;
    }

    @Override
    public boolean checkOdd(List<Integer> list) {
        Predicate<Integer> isOdd = num -> num % 2 != 0;
        boolean hasOdd = false;

        for (Integer num : list) {
            if (isOdd.test(num)) {
                System.out.printf("%d ", num);
                hasOdd = true;
            }
        }

        return hasOdd;
    }
}
