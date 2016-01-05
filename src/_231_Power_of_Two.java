/**
 * Created by Sorcerer on 2016/1/5 0005.
 * <p>
 * https://leetcode.com/problems/power-of-two/
 */
public class _231_Power_of_Two {

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        while ((n & 1) == 0) {
            n >>>= 1;
        }
        return n == 1;
    }
}
