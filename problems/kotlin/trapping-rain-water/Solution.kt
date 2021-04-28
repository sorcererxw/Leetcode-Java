package solution._42_Trapping_Rain_Water

import util.println

/**
 * @author: Sorcerer
 * @date: 2/24/2019
 * @description: https://leetcode.com/problems/trapping-rain-water/
 *
 * 参考图片 https://leetcode.com/problems/trapping-rain-water/Figures/42/trapping_rain_water.png
 * 从左加到右和从右加到左，真正的积水部分会重合，而其他的部分不会重叠
 * 所以 left + right = all + answer
 */
class Solution {
    fun trap(height: IntArray): Int {
        var maxHeight = 0

        var sumFromLeft = 0
        var now = 0
        for (i in 0 until height.size) {
            val h = height[i]
            maxHeight = Math.max(maxHeight, h)
            if (h >= now) {
                now = h
            } else {
                sumFromLeft += now - h
            }
        }

        var sumFromRight = 0
        var sumOfAll = 0
        now = 0
        for (i in height.size - 1 downTo 0) {
            val h = height[i]
            sumOfAll += maxHeight - h
            if (h >= now) {
                now = h
            } else {
                sumFromRight += now - h
            }
        }

        return sumFromLeft + sumFromRight - sumOfAll
    }
}


fun main(args: Array<String>) {
    Solution().trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)).println()
}