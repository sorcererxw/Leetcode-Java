package solution._151_Reverse_Words_in_a_String

import util.println
import java.util.*

/**
 * @author: sorcererxw
 * @date: 2019/4/1
 * @description:
 */
class Solution {
    fun reverseWords(s: String): String {
        val stack: Stack<String> = Stack()
        var st = 0
        var now = 0
        for (i in 0..s.length) {
            if (i == s.length || s[i] == ' ') {
                if (st < i) {
                    stack.push(s.substring(st, i))
                }
                st = i + 1
                continue
            }
        }
        val builder = StringBuilder()
        while (stack.isNotEmpty()) {
            if (builder.isNotEmpty()) {
                builder.append(" ")
            }
            builder.append(stack.pop())
        }
        return builder.toString()
    }
}

fun main() {
    Solution().reverseWords("the sky is blue").println()
    Solution().reverseWords("  hello world!  ").println()
    Solution().reverseWords("a good   example a").println()
}