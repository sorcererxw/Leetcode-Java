package solution._605_Can_Place_Flowers

import util.println

class Solution {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        var count = 0
        val size = flowerbed.size
        if (size == 0) count = 0
        else if (size == 1) count = if (flowerbed[0] == 0) 1 else 0
        else {
            for (i in 0 until size) {
                if (flowerbed[i] == 1) continue
                if (i == 0 && flowerbed[i + 1] == 1) {
                    continue
                } else if (i == size - 1 && flowerbed[i - 1] == 1) {
                    continue
                } else if (i > 0 && i < size - 1) {
                    if (flowerbed[i - 1] == 1 || flowerbed[i + 1] == 1) continue
                }
                flowerbed[i] = 1
                count++
                if (count >= n) return true
            }
        }
        return count >= n
    }
}

fun main() {
    Solution().canPlaceFlowers(intArrayOf(1, 0, 0, 0, 1), 2).println()
}