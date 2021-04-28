import java.util.Arrays;

/**
 * Author: Sorcerer
 * Date: 2018/4/17
 * Description:
 */

public class _561_Array_Partition_I {
    static class Solution {
        public int arrayPairSum(int[] nums) {
            Arrays.sort(nums);
            int sum = 0;
            for (int i = 0; i < nums.length; i += 2) {
                sum += nums[i];
            }
            return sum;
        }
    }

    public static void main(String... args) {
        Solution solution = new Solution();
        System.out.println(solution.arrayPairSum(new int[]{1, 4, 3, 2}));
    }
}
