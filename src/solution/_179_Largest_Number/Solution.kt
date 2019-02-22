package solution._179_Largest_Number

/**
 * @author: Sorcerer
 * @date: 2/22/2019
 * @description: https://leetcode.com/problems/largest-number/
 * 直接组合比较，而不是单个比较
 */

class Solution {
    fun largestNumber(nums: IntArray): String {
        val list = nums.map { it.toString() }
                .sortedWith(Comparator { o1, o2 -> (o2 + o1).compareTo(o1 + o2) })
        if (list[0] == "0") return "0"
        return list.joinToString(separator = "")
    }
}

fun main(args: Array<String>) {
    println(Solution().largestNumber(intArrayOf(0,0)))
    println(Solution().largestNumber(intArrayOf(10, 2)))
    println(Solution().largestNumber(intArrayOf(3, 30, 34, 5, 9)))
}