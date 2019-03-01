package solution._215_Kth_Largest_Element_in_an_Array

import util.println
import java.util.*

/**
 * @author: sorcererxw
 * @date: 3/1/2019
 * @description: https://leetcode.com/problems/kth-largest-element-in-an-array/
 * 使用快速排序思路，一遍确定每个值位置的同时，不断逼近 k 的位置
 * 需要先手动打乱一下数组的排序，防止有序数组对快排效率的影响
 */
class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        var low = 0
        var high = nums.size - 1
        val target = nums.size - k
        if (nums.size <= target) return -1
        shuffle(nums)
        while (low < high) {
            val mid = partation(nums, low, high)
            if (mid == target) {
                break
            } else if (mid < target) {
                low = mid + 1
            } else if (mid > target) {
                high = mid - 1
            }
        }
        return nums[target]
    }

    private fun partation(nums: IntArray, low: Int, high: Int): Int {
        var i = low
        var j = high + 1
        val v = nums[low]
        while (true) {
            while (nums[++i] < v)
                if (i == high) break
            while (nums[--j] > v)
                if (j == low) break
            if (i >= j) break
            swap(nums, i, j)
        }
        swap(nums, low, j)
        return j
    }

    private fun swap(nums: IntArray, i: Int, j: Int) {
        val t = nums[i]
        nums[i] = nums[j]
        nums[j] = t
    }

    private fun shuffle(nums: IntArray) {
        val random = Random()
        for (i in 0 until nums.size) {
            val idx = random.nextInt(nums.size - i)
            swap(nums, i, i + idx)
        }
    }
}


fun main(args: Array<String>) {
    Solution().findKthLargest(intArrayOf(3, 2, 1, 5, 6, 4), 2).println()
    Solution().findKthLargest(intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6), 4).println()
}