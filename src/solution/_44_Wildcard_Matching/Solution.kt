package solution._44_Wildcard_Matching

import util.println

/**
 * @author: Sorcerer
 * @date: 2/25/2019
 * @description: https://leetcode.com/problems/wildcard-matching/
 * 参考 #10
 */
class Solution {
    fun isMatch(s: String, p: String): Boolean {
        val sLen = s.length
        val pLen = p.length
        val dp = Array(sLen + 1) { BooleanArray(pLen + 1) { false } }


        dp[sLen][pLen] = true
        // 从后到前对*进行赋值
        for (j in pLen-1 downTo 0) {
            if (p[j] != '*') break
            else dp[sLen][j] = true
        }

        for (i in sLen - 1 downTo 0) {
            for (j in pLen - 1 downTo 0) {
                dp[i][j] = if (s[i] == p[j] || p[j] == '?')
                    dp[i + 1][j + 1]
                else if (p[j] == '*')
                    dp[i][j + 1] /* 无视 ‘*’ */ || dp[i + 1][j] /* 保留 ‘*’ */
                else false
            }
        }
        return dp[0][0]
    }
}

fun main(args: Array<String>) {
    Solution().isMatch("aa","a*").println()
}