package solution._35_Search_Insert_Position

/**
 * @author: Sorcerer
 * @date: 2/13/2019
 * @description: https://leetcode.com/problems/search-insert-position/
 */

class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var lo = 0
        var hi = nums.size - 1
        while (lo <= hi) {
            val mid = lo + (hi - lo) / 2
            if (nums[mid] >= target) {
                if (mid == 0) return 0
                else if (nums[mid - 1] < target) {
                    return mid
                } else {
                    hi = mid - 1
                }
            } else if (nums[mid] < target) {
                lo = mid + 1
            }
        }
        return nums.size
    }
}

fun main(args: Array<String>) {
    assert(Solution().searchInsert(intArrayOf(1, 3, 5, 6), 5)==2)
    assert(Solution().searchInsert(intArrayOf(1, 3, 5, 6), 2)==1)
    assert(Solution().searchInsert(intArrayOf(1, 3, 5, 6), 7)==4)
    assert(Solution().searchInsert(intArrayOf(1, 3, 5, 6), 0)==0)
}
