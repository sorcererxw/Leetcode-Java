package solution._300_Longest_Increasing_Subsequence

import java.util.*

/**
 * @author: Sorcerer
 * @date: 2/17/2019
 * @description: https://leetcode.com/problems/longest-increasing-subsequence/
 */

class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val n = nums.size
        if (n == 0) return 0
        val dp = IntArray(n)
        dp[0] = 1
        var result = 1
        for (i in 1 until n) {
            var max = 0
            for (j in 0 until i) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j])
                }
            }
            dp[i] = max + 1
            result = Math.max(result, dp[i])
        }
        return result
    }
}

fun main(args: Array<String>) {
    println(Solution().lengthOfLIS(intArrayOf(10,9,2,5,3,7,101,18)))
}