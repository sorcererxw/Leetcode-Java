package solution._46_Permutations

import util.println
import java.util.*

/**
 * @author: Sorcerer
 * @date: 2/27/2019
 * @description: https://leetcode.com/problems/permutations/
 */
class Solution {
    private lateinit var vis: BooleanArray
    private lateinit var result: MutableList<List<Int>>
    private lateinit var stack: LinkedList<Int>
    private lateinit var nums: IntArray
    fun permute(nums: IntArray): List<List<Int>> {
        vis = BooleanArray(nums.size) { false }
        result = ArrayList()
        stack = LinkedList()
        this.nums = nums

        dfs()

        return result
    }

    private fun dfs() {
        if (stack.size == nums.size) {
            result.add(stack.toList())
            return
        }
        for (i in 0 until nums.size) {
            if (vis[i]) continue
            vis[i] = true
            stack.addLast(nums[i])
            dfs()
            stack.removeLast()
            vis[i] = false
        }
    }
}

fun main(args: Array<String>) {
    Solution().permute(intArrayOf(1, 2, 3)).println()
}