package solution._647_Palindromic_Substrings

/**
 * @author: Sorcerer
 * @date: 2/18/2019
 * @description: https://leetcode.com/problems/palindromic-substrings/
 */
class Solution {

    fun countSubstrings(s: String): Int {
        var count = 0
        for (i in 0 until s.length) {
            count += check(s, i, i)
            count += check(s, i, i + 1)
        }
        return count
    }

    private fun check(s: String, left: Int, right: Int): Int {
        var cnt = 0
        var l = left
        var r = right
        while (l >= 0 && l < s.length
                && r >= 0 && r < s.length
                && s[l] == s[r]) {
            cnt++
            l--
            r++
        }
        return cnt
    }
}


fun main(args: Array<String>) {
    println(Solution().countSubstrings("aaa"))
}