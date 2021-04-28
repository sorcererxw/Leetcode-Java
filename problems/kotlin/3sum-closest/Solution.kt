package solution._16_

/**
 * @author: Sorcerer
 * @date: 2/12/2019
 * @description: https://leetcode.com/problems/3sum-closest/
 * 方法与 #15 题相同
 */

class Solution {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        val arr = nums.sortedArray()
        var minGap = 0
        for (i in 0 until arr.size) {
            var lo = i + 1
            var hi = arr.size - 1
            while (lo < hi) {
                val sum = arr[i] + arr[lo] + arr[hi] - target
                if (minGap == 0 || Math.abs(sum) < Math.abs(minGap)) {
                    minGap = sum
                }
                when {
                    sum == 0 -> return target
                    sum < 0 -> lo++
                    sum > 0 -> hi--
                }
            }
        }
        return target + minGap
    }
}

fun main(args: Array<String>) {
    println(
            Solution().threeSumClosest(intArrayOf(0,1,2),3)
    )
}