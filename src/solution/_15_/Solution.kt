package solution._15_

/**
 * @author: Sorcerer
 * @date: 2/11/2019
 * @description: O(n^2)
 * 先固定第一个值，然后问题变成子问题：有序数组当中寻找和为某一值的组合
 * 子问题解法为两头指针向中间移动
 */
class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val arr = nums.sortedArray()
        val result: MutableList<List<Int>> = ArrayList()
        for (i in 0 until arr.size) {
            if (i != 0 && arr[i] == arr[i - 1]) continue
            var lo = i + 1
            var hi = arr.size - 1
            while (lo < hi) {
                val sum = arr[lo] + arr[hi] + arr[i]
                when {
                    sum == 0 -> {
                        result.add(listOf(arr[i], arr[lo], arr[hi]))
                        while (lo < hi && arr[lo] == arr[lo + 1]) lo++
                        while (lo < hi && arr[hi] == arr[hi - 1]) hi--
                        lo++
                        hi--
                    }
                    sum > 0 -> hi--
                    sum < 0 -> lo++
                }
            }
        }
        return result
    }
}

fun main(args: Array<String>) {
    val source = intArrayOf(-1,0,1,2,-1,-4)
    println(Solution().threeSum(source))
}