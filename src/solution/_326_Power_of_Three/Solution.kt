package solution._326_Power_of_Three

/**
 * @author: Sorcerer
 * @date: 2/22/2019
 * @description: https://leetcode.com/problems/power-of-three/
 */

class Solution {
    private val max = 1162261467 // 3^19

    fun isPowerOfThree(n: Int): Boolean {
        if (n > max || n <= 0) return false
        return max % n == 0
    }
}
