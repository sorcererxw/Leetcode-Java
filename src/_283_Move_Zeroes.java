import util.Utility;

/**
 * Created by Sorcerer on 2016/1/3 0003.
 * <p>
 * https://leetcode.com/problems/move-zeroes/
 */
public class _283_Move_Zeroes {

    public static void main(String[] args) {
        int[] a = new int[]{3, 1, 0, 0, 12};
        moveZeroes(a);
        Utility.printIntArray(a);
    }

    public static void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int j = i + 1;
                while (j < nums.length && nums[j] == 0) {
                    j++;
                }
                if (j >= nums.length) {
                    break;
                }
                nums[i] = nums[j];
                nums[j] = 0;
            }
        }
    }

    public static void moveZeroes1(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                while (nums[j] == 0) {
                    j--;
                    if (j <= i) {
                        return;
                    }
                }
                nums[i] = nums[j];
                nums[j] = 0;
            }
        }
    }
}
