package solution._91_Decode_Ways

/**
 * @author: Sorcerer
 * @date: 2/19/2019
 * @description: https://leetcode.com/problems/decode-ways/
 */
class Solution {
    fun numDecodings(s: String): Int {
        if (s.isEmpty()) return 0
        val n = s.length
        val dp = IntArray(n + 1)
        dp[n] = 1
        if (s[n - 1] == '0') dp[n - 1] = 0
        else dp[n - 1] = 1
        for (i in n - 2 downTo 0) {
            if (s[i] == '0') continue // 因为0只有可能与他人一起组成两位，所以不单独处理

            val it = s[i] - '0'
            val last = s[i + 1] - '0'
            val pair = it*10 + last
            dp[i] = if (pair <= 26) dp[i + 1] + dp[i + 2] else dp[i + 1]
        }
        println(dp.toList())
        return dp[0]
    }
}

fun main(args: Array<String>) {
    println(Solution().numDecodings("226"))
    println(Solution().numDecodings("1"))
    println(Solution().numDecodings("01"))

    println(Solution().numDecodings("11111"))

    println(Solution().numDecodings("12"))
    println(Solution().numDecodings("226"))
}