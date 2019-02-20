package solution._162_Find_Peak_Element

/**
 * @author: Sorcerer
 * @date: 2/21/2019
 * @description: https://leetcode.com/problems/find-peak-element/
 * 二分搜索找peak
 * 当mid处于上坡中
 * 如果 mid < mid+1, 那么说明 peak 位置 > mid
 * 如果 mid > mid+1，那么说明 peak 位置 <= mid
 *
 * 当mid处于下坡中
 * 如果 mid < mid+1, 那么说明 peak 位置 > mid
 * 如果 mid > mid+1，那么说明 peak 位置 <= mid
 */
class Solution {
    fun findPeakElement(nums: IntArray): Int {
        var low = 0
        var high = nums.size - 1
        while (low < high) {
            val mid = low + (high - low) / 2
            if (nums[mid] > nums[mid + 1]) {
                high = mid
            } else {
                low = mid + 1
            }
        }
        return low
    }
}

fun main(args: Array<String>) {
    println(Solution().findPeakElement(intArrayOf(1,2,3,1)))
    println(Solution().findPeakElement(intArrayOf(1,2,1,3,5,6,4)))
}