package solution._678_

import java.util.*

/**
 * @author: sorcererxw
 * @date: 1/22/2019
 * @description:
 */
class Solution {
    fun checkValidString(s: String): Boolean {
        val leftStack: Stack<Char> = Stack()
        for (i in 0 until s.length) {
            val c = s[i]
            if (c == '(') {
                leftStack.push(c)
            } else if (c == ')') {
                if (leftStack.isEmpty()) return false
                if (leftStack.peek() == '(' || leftStack.peek() == '*') {
                    leftStack.pop()
                } else {
                    return false
                }
            } else {
                leftStack.push('*')
            }
        }
        if (leftStack.isEmpty()) return true
        val rightStack: Stack<Char> = Stack()
        while (!leftStack.isEmpty()) {
            val c = leftStack.pop()
            if (c == '(') {
                if (rightStack.isEmpty()) return false
                if (rightStack.peek() == '*') {
                    rightStack.pop()
                } else {
                    return false
                }
            } else {
                rightStack.push('*')
            }
        }
        return true
    }
}

fun main(args: Array<String>) {
    arrayOf(
//            "",
//            "*",
            "(*)"
//            "**",
//            "()",
//            "(*",
//            "((",
//            "))",
//            ")(",
//            "*(",
//            ")*",
//            "(*)*))"
    ).forEach { println(it + ": " + Solution().checkValidString(it)) }
}