package solution._55_Jump_Game

/**
 * @author: Sorcerer
 * @date: 2/17/2019
 * @description: https://leetcode.com/problems/jump-game/
 * 从头到尾扫描一遍
 * 每走一步当前能量-1
 * 走到一格，把当前能量设置为max(剩余能量，格子能量）
 */
class Solution {
    fun canJump(nums: IntArray): Boolean {
        if(nums.isEmpty())return false
        var energy = 0
        var idx = 0
        do {
            energy = Math.max(energy - 1, nums[idx])
            idx++
        } while (energy > 0 && idx < nums.size)
        return idx == nums.size
    }
}

fun main(args: Array<String>) {
    println(Solution().canJump(intArrayOf()))
    println(Solution().canJump(intArrayOf(2,3,1,1,4)))
    println(Solution().canJump(intArrayOf(3,2,1,0,4)))
}