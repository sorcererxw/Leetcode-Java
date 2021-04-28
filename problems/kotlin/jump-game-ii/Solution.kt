package solution._45_Jump_Game_II

/**
 * @author: Sorcerer
 * @date: 2/19/2019
 * @description: https://leetcode.com/problems/jump-game-ii/
 * 贪心
 */
class Solution {
    fun jump(nums: IntArray): Int {
        var count = 0
        var now = 0
        var max = 0
        for (i in 0 until nums.size - 1) { // 注意范围
            if (now >= nums.size) break
            max = Math.max(max, i + nums[i])
            if (now == i) {
                now = max
                count++
            }
        }
        return count
    }
}

fun main(args: Array<String>) {
    println(Solution().jump(intArrayOf(2, 3, 1, 1, 4)))
}