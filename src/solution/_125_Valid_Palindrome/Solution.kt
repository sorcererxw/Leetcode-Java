package solution._125_Valid_Palindrome

/**
 * @author: Sorcerer
 * @date: 2/22/2019
 * @description: https://leetcode.com/problems/valid-palindrome/
 */
class Solution {
    fun isPalindrome(s: String): Boolean {
        var low = 0
        var high = s.length - 1
        while (low <= high) {
            val slow = s[low].toLowerCase()
            val shigh = s[high].toLowerCase()
            if (slow !in 'a'..'z' && slow !in '0'..'9') {
                low++
                continue
            }
            if (shigh !in 'a'..'z' && shigh !in '0'..'9') {
                high--
                continue
            }
            if (slow != shigh) return false
            low++
            high--
        }
        return true
    }
}

fun main(args: Array<String>) {
    println(Solution().isPalindrome("OP"))
    println(Solution().isPalindrome("race a car"))
    println(Solution().isPalindrome("A man, a plan, a canal: Panama"))
}
