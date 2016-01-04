/**
 * Created by Sorcerer on 2016/1/4 0004.
 * <p>
 * https://leetcode.com/problems/climbing-stairs/
 */
public class _70_Climbing_Stairs {

    /*
    0 1
    1 1
    2 2
    3 3
    4 5
     */

    public int climbStairs(int n) {
        int a = 1;
        int b = 1;
        int k = 1;
        while (k != n) {
            int tmp = b;
            b = a + b;
            a = tmp;
            k++;
        }
        return b;
    }

//    public int climbStairs(int n) {
//        if (n == 1 || n == 0) {
//            return 1;
//        }
//        return climbStairs(n - 1) + climbStairs(n - 2);
//    }
}
