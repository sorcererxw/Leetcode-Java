package solution._11_Container_With_Most_Water

/**
 * @author: Sorcerer
 * @date: 2/17/2019
 * @description: https://leetcode.com/problems/container-with-most-water/
 * 先找两端的杆子，计算
 * 然后想办法增大当前的容量，因为当前的宽度已经最大了，只有让短边边长才可
 * 类似于贪心，当前只考虑最有利的改变
 * 任何情况下都倾向于改变短边
 */

class Solution {
    fun maxArea(height: IntArray): Int {
        var l = 0
        var r = height.size - 1
        var max = -1
        while (l < r) {
            max = Math.max(max, (r - l) * Math.min(height[l], height[r]))
            if (height[l] <= height[r]) l++ else r--
        }
        return max
    }
}

fun main(args: Array<String>) {
    val result = Solution().maxArea(intArrayOf(2,3,4,5,18,17,6))
    println(result)
}