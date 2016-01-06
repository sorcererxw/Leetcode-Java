import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Sorcerer on 2016/1/6 0006.
 * <p>
 * https://leetcode.com/problems/remove-element/
 */
public class _27_Remove_Element {

    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int k=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
