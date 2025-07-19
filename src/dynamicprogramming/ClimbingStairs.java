package dynamicprogramming;

import java.util.HashMap;

public class ClimbingStairs {

    public int climbStairs(int n) {
        int first = 1;
        int second = 1;
        int temp;
        for (int i = n - 2; i >= 0; i--) {
            temp = second;
            second = first + second;
            first = temp;
        }

        return second;
    }
}
