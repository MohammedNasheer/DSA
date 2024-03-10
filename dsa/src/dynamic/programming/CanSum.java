package dynamic.programming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CanSum {
    public static void main (String[] args) {

//        System.out.println(canSum(7, List.of(2, 3))); //true
//        System.out.println(canSum(7, List.of(5, 3, 4, 7))); //true
//        System.out.println(canSum(7, List.of(2, 4)));  //false
//
//        System.out.println(canSum(8, List.of(2, 3, 5))); //true
        System.out.println(canSumWithMemo(300, List.of(7, 14), new HashMap <>())); //false
        System.out.println(canSumWithMemo(400, List.of(7, 14), new HashMap <>())); //false
    }


    /**
     * @param targetSum
     * @param numbers
     * @return true or false
     * <p>
     * Time Complexity O(m^n)
     * Space complexity O(M).
     */
    public static Boolean canSum (int targetSum, List < Integer > numbers) {

        if (targetSum < 0) return false;

        if (targetSum == 0) return true;

        for (Integer number : numbers) {

            Integer reminder = targetSum - number;

            if (canSum(reminder, numbers)) {
                System.out.printf("Number : %d Reminder : %d  %n", number, reminder);
                return true;
            }
        }

        return false;
    }


    /**
     *
     * @param targetSum
     * @param numbers
     * @param memo
     * @return
     *
     * TimeComplexity O(n*m)
     * SpaceComplexity is O(m).
     *
     * */
    public static boolean canSumWithMemo (int targetSum, List < Integer > numbers, Map < Integer, Boolean > memo) {

        if (memo.containsKey(targetSum)) return memo.get(targetSum);

        if (targetSum < 0) return false;

        if (targetSum == 0) return true;

        for (Integer number : numbers) {

            Integer reminder = targetSum - number;

            if (canSumWithMemo(reminder, numbers, memo)) {
                //System.out.printf("Number : %d Reminder : %d ", number, reminder);
                memo.put(targetSum, true);

                return true;
            }
        }

        memo.put(targetSum, false);
        return false;
    }

}
