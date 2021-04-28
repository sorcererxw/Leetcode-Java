package solution._189_Rotate_Array

/**
 * @author: Sorcerer
 * @date: 2/22/2019
 * @description: https://leetcode.com/problems/rotate-array/
 */
class Solution {
    fun rotate(nums: IntArray, k: Int) {
        val offset = nums.size - k % nums.size
        reverse(nums, 0, offset - 1)
        reverse(nums, offset, nums.size - 1)
        reverse(nums, 0, nums.size - 1)
    }

    private fun reverse(nums: IntArray, st: Int, ed: Int) {
        if (st < 0 || ed < 0 || st >= nums.size || ed >= nums.size) return
        var low = st
        var high = ed
        while (low < high) {
            val t = nums[low]
            nums[low] = nums[high]
            nums[high] = t
            low++
            high--
        }
    }
}

fun main(args: Array<String>) {
    Solution().rotate(intArrayOf(1), 1)
    Solution().rotate(intArrayOf(1, 2, 3, 4, 5, 6, 7), 3)
}