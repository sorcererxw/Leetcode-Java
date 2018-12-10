import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sorcerer on 2016/1/7 0007.
 * <p>
 * https://leetcode.com/problems/palindrome-number/
 */
public class _9_Palindrome_Number {

    public static void main(String[] args) {
        System.out.println(isPalindrome(10));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        for (int i = 1, j = getLengthOfInt(x); i <= j; i++, j--) {
            if (getIndexOfInt(x, i) != getIndexOfInt(x, j)) {
                return false;
            }
        }
        return true;
    }

    public static int getIndexOfInt(int x, int index) {
        x /= (int) Math.pow(10, getLengthOfInt(x) - index);
        return x % 10;
    }

    public static int getLengthOfInt(int x) {
        return (int) Math.log10(x) + 1;
    }
}
