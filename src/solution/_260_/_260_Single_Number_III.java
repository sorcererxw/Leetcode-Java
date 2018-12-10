import models.ListNode;
import util.Utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sorcerer on 2016/1/15 0015.
 * <p>
 * https://leetcode.com/problems/single-number-iii/
 */
public class _260_Single_Number_III {

    public static void main(String[] args) {
        Utility.printIntArray(singleNumber(new int[]{-1139700704,-1653765433}));
    }


    /*
     11
    101
    10
    11
     10
     11
     01
     11
     10
    101
    111
     */
    public static int[] singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        int k = getBitOf1(res);
        return generate(nums, k);
    }

    private static int[] generate(int[] target, int k) {
        int res1 = 0;
        int res2 = 0;
        for (int i = 0; i < target.length; i++) {
            if (judge(target[i], k+1)) {
                res1 ^= target[i];
            } else {
                res2 ^= target[i];
            }
        }
        return new int[]{res1, res2};
    }

    private static boolean judge(int a, int k) {
        a >>= k;
        return (a & 1) == 0;
    }

    private static int getBitOf1(int a) {
        for (int i = 0; a > 0; i++) {
            if ((a & 1) == 0) {
                return i;
            }
            a >>= 2;
        }
        return -1;
    }
}
