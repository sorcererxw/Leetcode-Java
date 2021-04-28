/**
 * Created by Sorcerer on 2016/1/6 0006.
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class _26_Remove_Duplicates_from_Sorted_Array {

    public int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int k=1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]!=nums[i-1]){
                nums[k]=nums[i];
                k++;
            }
        }
        return k;
    }
}
