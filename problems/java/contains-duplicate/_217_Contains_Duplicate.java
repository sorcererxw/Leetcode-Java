import java.util.Arrays;

/**
 * Created by Sorcerer on 2016/1/4 0004.
 *
 * https://leetcode.com/problems/contains-duplicate/
 */
public class _217_Contains_Duplicate {

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }
}
