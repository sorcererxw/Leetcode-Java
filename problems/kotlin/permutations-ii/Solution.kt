package solution._47_Permutations_II

import util.println
import kotlin.collections.ArrayList

class Solution {

    private lateinit var result: MutableList<List<Int>>
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        result = ArrayList()
        if (nums.isEmpty()) return result
        find(nums.sortedArray(), 0, nums.size - 1)
        return result
    }

    private fun find(nums: IntArray, st: Int, ed: Int) {
        if (st == ed) {
            result.add(nums.toList())
            return
        }
        for (k in st..ed) {
            if (st != k && nums[st] == nums[k]) continue
            swap(nums, st, k) // 序列当中不一样的数字轮流放到头部
            find(nums.copyOf(), st + 1, ed) // 不断让问题规模变成子串的排列
        }
    }

    private fun swap(nums: IntArray, i: Int, j: Int) {
        val k = nums[i]
        nums[i] = nums[j]
        nums[j] = k
    }
}

fun main() {
    Solution().permuteUnique(intArrayOf(1,1,2)).println()
    Solution().permuteUnique(intArrayOf(1,2,2,3)).println()
}