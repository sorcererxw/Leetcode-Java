package solution._7_Reverse_Integer

import util.println

/**
 * @author: Sorcerer
 * @date: 2/26/2019
 * @description: https://leetcode.com/problems/reverse-integer/
 */
class Solution {
    fun reverse(x: Int): Int {
        val negative = x < 0
        var num = Math.abs(x).toLong()
        var result: Long = 0
        while (num > 0) {
            result = result * 10 + num % 10
            num /= 10
            if ((!negative && result > Int.MAX_VALUE) || (negative && -result < Int.MIN_VALUE)) {
                result = 0
                break
            }
        }
        return (if (negative) -1 else 1) * result.toInt()
    }
}

fun main(args: Array<String>) {
    Solution().reverse(1534236469).println()
    Solution().reverse(123).println()
    Solution().reverse(-123).println()
    Solution().reverse(120).println()
    Solution().reverse(0).println()

}