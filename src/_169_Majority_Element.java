import java.util.Arrays;

/**
 * Created by Sorcerer on 2016/1/4 0004.
 * <p>
 * https://leetcode.com/problems/majority-element/
 */
public class _169_Majority_Element {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
