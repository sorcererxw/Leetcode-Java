package solution._10_Regular_Expression_Matching

import util.println

/**
 * @author: Sorcerer
 * @date: 2/25/2019
 * @description: https://leetcode.com/problems/regular-expression-matching/
 * .可替代任何字符 *可表示任意长度（*>=0)
 * .* 可表示任何字符串，哪怕其中字符不同
 * 使用 dp，空间换时间
 */
class Solution {
    fun isMatch(s: String, p: String): Boolean {
        val sLen = s.length
        val pLen = p.length
        val dp: Array<BooleanArray> = Array(sLen + 1) { BooleanArray(pLen + 1) { false } }
        dp[sLen][pLen] = true // 末尾空序列是匹配的
        for (i in sLen downTo 0) {
            for (j in pLen - 1 downTo 0) {
                val match = i < sLen && (p[j] == s[i] || p[j] == '.')
                if (j + 1 < pLen && p[j + 1] == '*') {
                    dp[i][j] = dp[i][j + 2]  // *=0 的情况
                            || (match && dp[i + 1][j]) // *>0的情况，这个时候p不动继续匹配后面的内容，s往后移动一位
                } else {
                    dp[i][j] = match && dp[i + 1][j + 1] // 当作常规字符处理，那么就都往后挪
                }
            }
        }
        return dp[0][0]
    }
}

fun main(args: Array<String>) {
    Solution().isMatch("aa", "a").println()
}