import java.util.Arrays;

/**
 * Created by Sorcerer on 2016/1/6 0006.
 */
public class _198_House_Robber {

    public static void main(String[] args) {
        int[] nums = {5, 2, 1, 3};
        Utility.printIntArray(nums);
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        int[] res = new int[nums.length];
        int Max = 0;
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i];
            int max = -1;
            for (int j = i - 2; j >= 0; j--) {
                max = Math.max(max, res[j]);
            }
            if (max != -1) {
                res[i] += max;
            }
            Max = Math.max(Max, res[i]);
        }
        return Max;
    }
}
