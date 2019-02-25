package solution._10_Regular_Expression_Matching

/**
 * @author: Sorcerer
 * @date: 2/25/2019
 * @description: https://leetcode.com/problems/regular-expression-matching/
 * .可替代任何字符 *可表示任意长度（*>=0)
 * .* 可表示任何字符串，哪怕其中字符不同
 */
class RecursionSolution {
    fun isMatch(s: String, p: String): Boolean {
        if (p.isEmpty()) return s.isEmpty()
        val match = s.isNotEmpty() && (p[0] == s[0] || p[0] == '.')

        return if (p.length >= 2 && p[1] == '*') {
            (isMatch(s, p.substring(2)) // *=0 的情况
                    || (match && isMatch(s.substring(1), p))) // *>0的情况，这个时候p不动继续匹配后面的内容，s往后移动一位
        } else {
            // p[1] != *, 当做 p 这个位置是一个常规字符，两者都往后移
            match && isMatch(s.substring(1), p.substring(1))
        }
    }
}