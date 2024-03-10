package dynamic.programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HowSum {
    public static void main (String[] args) {

//        System.out.println(howSum(7, List.of(2, 3))); //true
//        System.out.println(howSum(7, List.of(5, 3, 4, 7))); //true
//        System.out.println(howSum(7, List.of(2, 4)));  //false
//        System.out.println(howSum(0, List.of(2, 3, 5))); //true
//
//        System.out.println(howSum(8, List.of(2, 3, 5))); //true
//        System.out.println(howSum(300, List.of(7, 14))); //false
         System.out.println(howSumWithMemo(300, List.of(2, 14), new HashMap <>())); //false
        System.out.println(howSumWithMemo(400, List.of(7, 14), new HashMap <>())); //false
    }


    /**
     * @param targetSum
     * @param numbers
     * @return true or false
     * <p>
     * Time Complexity O(m^n)
     * Space complexity O(M).
     */
    public static List <Integer> howSum (int targetSum, List <Integer> numbers) {

        if (targetSum < 0) return null;

        if (targetSum == 0) return new ArrayList <>();

        for (Integer number : numbers) {

            Integer reminder = targetSum - number;
            List <Integer> result = howSum(reminder, numbers);
            if (result != null) {
                result.add(number);
               // System.out.printf("Number : %d Reminder : %d  %n", number, reminder);
                return result;
            }
        }

        return null;
    }


    /**
     * @param targetSum
     * @param numbers
     * @param memo
     * @return TimeComplexity O(n*m)
     * SpaceComplexity is O(m).
     */
    public static List<Integer> howSumWithMemo (int targetSum, List <Integer> numbers, Map <Integer, List<Integer>> memo) {

        if (memo.containsKey(targetSum)) return memo.get(targetSum);

        if (targetSum < 0) return null;

        if (targetSum == 0) return new ArrayList <>();

        for (Integer number : numbers) {

            Integer reminder = targetSum - number;

            List<Integer> result = howSumWithMemo(reminder, numbers, memo);
            if (result!=null) {
                //System.out.printf("Number : %d Reminder : %d ", number, reminder);
                result.add(number);
                memo.put(targetSum, result);

                return result;
            }
        }

        memo.put(targetSum, null);
        return null;
    }

}
