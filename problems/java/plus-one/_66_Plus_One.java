/**
 * Created by Sorcerer on 2016/1/6 0006.
 * <p>
 * https://leetcode.com/problems/plus-one/
 */
public class _66_Plus_One {

    public int[] plusOne(int[] digits) {
        int i;
        for (i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + 1 >= 10) {
                digits[i] = 0;
                continue;
            } else {
                digits[i] += 1;
                break;
            }
        }
        if (i == -1) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            for (int j = 0; j < digits.length; j++) {
                res[j + 1] = digits[j];
            }
            return res;
        } else {
            return digits;
        }
    }
}
