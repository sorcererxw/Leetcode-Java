package solution._494_Target_Sum

/**
 * @author: Sorcerer
 * @date: 2/16/2019
 * @description: https://leetcode.com/problems/target-sum/
 */
class Solution {
    fun findTargetSumWays(nums: IntArray, S: Int): Int {
        return dfs(nums, S, nums.size-1)
    }

    private fun dfs(nums: IntArray, S: Int, end: Int): Int {
        if (end < 0) {
            return if (S == 0) 1 else 0
        }
        return dfs(nums, S + nums[end], end - 1) + dfs(nums, S - nums[end], end - 1)
    }
}

fun main(args: Array<String>) {
    val result = Solution().findTargetSumWays(intArrayOf(1, 1, 1, 1, 1),3)
    println(result)
}