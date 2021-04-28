package solution._80_Remove_Duplicates_from_Sorted_Array_II

import util.println

/**
 * @author: sorcererxw
 * @date: 2019/4/18
 * @description:
 */
class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var n = 0
        for (i in 0 until nums.size) {
            if (n < 2 || nums[i] > nums[n - 2]) {
                nums[n++] = nums[i]
            }
        }
        return n
    }
}

fun main() {
    Solution().removeDuplicates(intArrayOf(1, 1, 1, 2, 2, 3)).println()
    Solution().removeDuplicates(intArrayOf(0, 0, 1, 1, 1, 1, 2, 3, 3)).println()
}