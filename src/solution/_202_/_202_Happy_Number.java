import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sorcerer on 2016/1/4 0004.
 * <p>
 * https://leetcode.com/problems/happy-number/
 */
public class _202_Happy_Number {

    public static void main(String[] args) {
        isHappy(2);
    }

    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        while (sum != 1) {
            sum = 0;
            while (n > 0) {
                sum += Math.pow(n % 10, 2);
                n /= 10;
            }
            n = sum;
            if (set.add(sum) == false) {
                return false;
            }
        }
        return true;
    }
}
