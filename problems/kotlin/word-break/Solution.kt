package solution._139_Word_Break

/**
 * @author: Sorcerer
 * @date: 2/17/2019
 * @description: https://leetcode.com/problems/word-break/
 */
class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val dp = BooleanArray(s.length + 1) // 表示从 0-i 的位置子串能否被分割
        dp[0] = true // 空字符串可分割

        for (i in 1..s.length) {
            for (j in 0 until i) {
                // 如果 0-j 串可被分割，而且字典中包含 j-i 串，那么0-i串就可被分割
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true
                    break
                }
            }
        }
        return dp[s.length]
    }
}

fun main(args: Array<String>) {
    val result = Solution().wordBreak("leetcode", listOf("leet", "code"))
    println(result)
}