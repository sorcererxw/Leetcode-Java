package solution._374_Guess_Number_Higher_or_Lower;

/**
 * @author: Sorcerer
 * @date: 2/13/2019
 * @description: https://leetcode.com/problems/guess-number-higher-or-lower/
 */
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int lo = 1;
        int hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int result = guess(mid);
            if (result < 0) {
                hi = mid - 1;
            } else if (result > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int result = new Solution().guessNumber(10);
        System.out.println(result);
    }
}