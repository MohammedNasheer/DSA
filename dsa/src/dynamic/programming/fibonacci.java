package dynamic.programming;

import java.util.HashMap;
import java.util.Map;

public class fibonacci {

    // 1 2 3 4 5 6  7 8
    // 1 1 2 3 5 8 13 21
    public static void main (String[] args) {

        //normal fibo
        long currentTimeInMill = System.currentTimeMillis();

//        System.out.println(fibonacciProblem(5));   // Expected -> 5
//
//        System.out.printf( "Time in sec -> %d %n", (System.currentTimeMillis() - currentTimeInMill)/1000 );
//        currentTimeInMill = System.currentTimeMillis();
//        System.out.println(fibonacciProblem(40));  // Expected -> 102334155
//        System.out.printf("Time-> %d %n", (System.currentTimeMillis() - currentTimeInMill)/1000 );
//        currentTimeInMill = System.currentTimeMillis();
//        System.out.println(fibonacciProblem(50));  // Expected -> 12586...
//        System.out.printf( "Time-> %d %n",(System.currentTimeMillis() - currentTimeInMill)/1000 );


        // fibo with memorization from exponential TC to Linear TC i,.e O(n)

        System.out.println(fibonacciWithMemo(5, new HashMap<>()));   // Expected -> 5

        System.out.printf("Time in sec -> %d %n", (System.currentTimeMillis() - currentTimeInMill) / 1000);
        currentTimeInMill = System.currentTimeMillis();
        System.out.println(fibonacciWithMemo(40, new HashMap<>()));  // Expected -> 102334155
        System.out.printf("Time-> %d %n", (System.currentTimeMillis() - currentTimeInMill) / 1000);
        currentTimeInMill = System.currentTimeMillis();
        System.out.println(fibonacciWithMemo(50, new HashMap<>()));  // Expected -> 12586...
        System.out.printf("Time-> %d %n", (System.currentTimeMillis() - currentTimeInMill) / 1000);

    }


    // Classical approach  Time complexity O(2^n) & space complexity O(n).
    public static long fibonacciProblem (int num) {
        if (num <= 2) return 1;
        return fibonacciProblem(num - 1) + fibonacciProblem(num - 2);
    }

    // with Memorization of dynamic programming
    public static long fibonacciWithMemo (int num, Map<Integer, Long> memo) {

        if (memo.containsKey(num)) return memo.get(num);
        if (num <= 2) return 1;

        memo.put(num, fibonacciWithMemo(num - 1, memo) + fibonacciWithMemo(num - 2, memo));
        return memo.get(num);
    }


}
