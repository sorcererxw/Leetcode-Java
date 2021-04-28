package solution._33_Search_in_Rotated_Sorted_Array

import java.util.*

/**
 * @author: Sorcerer
 * @date: 2/19/2019
 * @description: https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
class Solution {
    fun search(nums: IntArray, target: Int): Int {
        if (nums.isEmpty()) return -1
        val sp = findSplitPoint(nums)
        println("split: $sp")

        val index = if (target >= nums[0]) {
            Arrays.binarySearch(nums, 0, sp + 1, target)
        } else {
            Arrays.binarySearch(nums, sp + 1, nums.size, target)
        }
        return if (index >= 0) index else -1
    }

    private fun findSplitPoint(nums: IntArray): Int {
        val n = nums.size
        val end = nums[n - 1]

        var lo = 0
        var hi = n - 1

        while (lo <= hi) {
            val mid = lo + (hi - lo) / 2
            if (mid == n - 1 || nums[mid] > nums[mid + 1]) return mid
            else if (nums[mid] > end) {
                lo = mid + 1
            } else if (nums[mid] < end) {
                hi = mid - 1
            }
        }
        return n - 1
    }
}

fun main(args: Array<String>) {
    println(Solution().search(intArrayOf(1, 3), 1))

    println(Solution().search(intArrayOf(1), 1))

    println(Solution().search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0))
    println(Solution().search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 3))
}