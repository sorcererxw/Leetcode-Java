package solution._394_Decode_String

import java.util.*

/**
 * @author: Sorcerer
 * @date: 2/16/2019
 * @description: https://leetcode.com/problems/decode-string/
 * 使用两个栈，一个存数字，一个存字母
 * 从头到尾扫描
 */
class Solution {
    fun decodeString(s: String): String {
        val source = "1[$s]"
        val timeStack: Stack<Int> = Stack()
        val clipStack: Stack<String> = Stack()
        var num = 0
        for (i in 0 until source.length) {
            if (source[i] == '[') {
                timeStack.push(num)
                clipStack.push("")
                num = 0
            } else if (source[i] == ']') {
                val time = timeStack.pop()
                val sb = StringBuilder()
                while (!clipStack.empty()) {
                    val top = clipStack.pop()
                    if (top.isEmpty()) break
                    sb.insert(0, top)
                }
                clipStack.push(buildString(sb.toString(), time))
            } else if (source[i] in '0'..'9') {
                num = num * 10 + (source[i] - '0')
            } else {
                clipStack.push("${source[i]}")
            }
        }
        return clipStack.pop()
    }

    private fun buildString(source: String, time: Int): String {
        val builder = StringBuilder()
        for (i in 0 until time) builder.append(source)
        return builder.toString()
    }
}

fun main(args: Array<String>) {
    println(Solution().decodeString("3[a]2[bc]") == "aaabcbc")
    println(Solution().decodeString("3[a2[c]]") == "accaccacc")
    println(Solution().decodeString("2[abc]3[cd]ef") == "abcabccdcdcdef")
}