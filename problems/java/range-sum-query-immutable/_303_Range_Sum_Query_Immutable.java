import java.util.Arrays;

/**
 * Created by Sorcerer on 2016/1/15 0015.
 * <p>
 * https://leetcode.com/problems/range-sum-query-immutable/
 */
public class _303_Range_Sum_Query_Immutable {

    public static void main(String[] args){
        NumArray array = new NumArray(new int[]{1,2,3,4,5,6});
        System.out.println(array.sumRange(1,3));
    }

    public static class NumArray {

        private int[] array;

        public NumArray(int[] nums) {
            array = Arrays.copyOf(nums, nums.length);
            Arrays.sort(array);
        }

        public int sumRange(int i, int j) {
            int k;
            i-=1;
            j-=1;
            for (k = 0; k < array.length; k++) {
                if(k>=i){
                    break;
                }
            }
            int sum = 0;
            for (; k <= j; k++) {
                sum+=array[k];
            }
            return sum;
        }
    }
}
