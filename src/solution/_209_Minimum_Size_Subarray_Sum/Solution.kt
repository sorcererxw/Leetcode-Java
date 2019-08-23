package solution._209_Minimum_Size_Subarray_Sum

import util.println

class Solution {
    fun minSubArrayLen(s: Int, nums: IntArray): Int {
        var l = 0
        var r = 0
        var count = 0
        var min = 0
        while (true) {
            if (count < s && r < nums.size) {
                count += nums[r++]
            } else if (count >= s && l < r) {
                count -= nums[l++]
            } else {
                break
            }
            if (count >= s) {
                min = if (min == 0) {
                    r - l
                } else {
                    Math.min(min, r - l)
                }
            }
        }
        return min
    }
}

fun main() {
    Solution().minSubArrayLen(7, intArrayOf(2, 3, 1, 2, 4, 3)).println()
}
