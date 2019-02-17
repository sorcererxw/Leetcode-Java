package solution._279_Perfect_Squares

/**
 * @author: Sorcerer
 * @date: 2/17/2019
 * @description: https://leetcode.com/problems/perfect-squares/
 * 简单dp
 */
class Solution {
    fun numSquares(n: Int): Int {
        val dp = IntArray(n + 1)
        dp[0] = 0
        for (i in 1..n) {
            val sqrt = Math.sqrt(i.toDouble()).toInt()
            if (i - sqrt * sqrt < 1) {
                dp[i] = 1
            } else {
                var min = Int.MAX_VALUE
                var j = 1
                while (j <= i - j) {
                    min = Math.min(min, dp[j] + dp[i - j])
                    j++
                }
                dp[i] = min
            }
        }
        return dp[n]
    }
}

fun main(args: Array<String>) {
    val result = Solution().numSquares(12)
    println(result)
}