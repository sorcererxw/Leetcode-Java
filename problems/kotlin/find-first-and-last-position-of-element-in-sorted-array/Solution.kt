package solution._34_Find_First_and_Last_Position_of_Element_in_Sorted_Array

/**
 * @author: Sorcerer
 * @date: 2/20/2019
 * @description: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 可以确定起点和终点的特征，使用两次二分查找
 */
class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        if (nums.isEmpty()) return intArrayOf(-1, -1)
        val start = findStart(nums, target)
        if (start == -1) return intArrayOf(-1, -1)
        val end = findEnd(nums, target)
        if (end == -1) return intArrayOf(-1, -1)
        return intArrayOf(start, end)
    }

    private fun findStart(nums: IntArray, target: Int): Int {
        var low = 0
        var high = nums.size - 1
        while (low <= high) {
            val mid = low + (high - low) / 2
            if (target == nums[mid] && (mid == 0 || nums[mid - 1] < target)) {
                return mid
            }
            if (nums[mid] < target) {
                low = mid + 1
            } else if (nums[mid] >= target) {
                high = mid - 1
            }
        }
        return -1
    }

    private fun findEnd(nums: IntArray, target: Int): Int {
        var low = 0
        var high = nums.size - 1
        while (low <= high) {
            val mid = low + (high - low) / 2
            if (target == nums[mid] && (mid == nums.size - 1 || nums[mid + 1] > target)) {
                return mid
            }
            if (nums[mid] <= target) {
                low = mid + 1
            } else if (nums[mid] > target) {
                high = mid - 1
            }
        }
        return -1
    }
}

fun main(args: Array<String>) {
    println(Solution().searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 8).toList())
    println(Solution().searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 6).toList())
}