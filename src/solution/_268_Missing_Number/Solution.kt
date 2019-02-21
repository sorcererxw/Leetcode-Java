package solution._268_Missing_Number

/**
 * @author: Sorcerer
 * @date: 2/22/2019
 * @description: https://leetcode.com/problems/missing-number/
 */
class Solution {
    fun missingNumber(nums: IntArray): Int {
        val n = nums.size
        var result = n * (n + 1) / 2
        for (i in 0 until n) {
            result -= nums[i]
        }
        return result
    }
}