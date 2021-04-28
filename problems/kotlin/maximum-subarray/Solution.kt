package solution._53_Maximum_Subarray

/**
 * @author: Sorcerer
 * @date: 2/14/2019
 * @description: https://leetcode.com/problems/maximum-subarray/
 */

class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var max = nums[0]
        var sum = 0
        for (i in 0 until nums.size) {
            sum += nums[i]
            if (sum > max) max = sum
            if (sum < 0) sum = 0
        }
        return max
    }
}

