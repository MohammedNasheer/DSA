package dynamic.programming;

import java.util.HashMap;
import java.util.Map;

public class GridTraveller {

    public static void main (String[] args) {

        System.out.println("   GridTraveller  ");
//        System.out.println(gridTraveller(2,3));     // 6
//        System.out.println(gridTraveller(3,2));     // 6
//        System.out.println(gridTraveller(10,10));   // 48620
//        System.out.println(gridTraveller(20,20));   // need to be optimised


        System.out.println(gridTravellerWithMemo(2, 3, new HashMap <>()));     // 6
        System.out.println(gridTravellerWithMemo(3, 2, new HashMap <>()));     // 6
        System.out.println(gridTravellerWithMemo(10, 10, new HashMap <>()));   // 48620
        System.out.println(gridTravellerWithMemo(20, 20, new HashMap <>()));   // 985525432

    }


    // Exponential TC O(2^m+n) & SC O(m+n)
    public static int gridTraveller (int row, int col) {

        if (row == 0 || col == 0) return 0;

        if (row == 1 && col == 1 && row == col) return 1;

        //System.out.printf("row -> %d  col -> %d  %n", row, col);

        return gridTraveller(row - 1, col) + gridTraveller(row, col - 1);

    }

    // Linear TC O(m+n) & SC O(m+n)
    public static int gridTravellerWithMemo (int row, int col, Map <String, Integer> memo) {

        String key = row + "," + col;
        String keyR = col + "," + row;

        if (memo.containsKey(key)) return memo.get(key);

        if (row == 0 || col == 0) return 0;

        if (row == 1 && col == 1 && row == col) return 1;

        //System.out.printf("row -> %d  col -> %d  %n", row, col);

        memo.put(key, gridTravellerWithMemo(row - 1, col, memo) + gridTravellerWithMemo(row, col - 1, memo));

        return memo.get(key);
    }
}
