package solution._150_Evaluate_Reverse_Polish_Notation

import java.util.*

/**
 * @author: Sorcerer
 * @date: 2/20/2019
 * @description: https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */
class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val numStack: Stack<Int> = Stack()
        for (i in 0 until tokens.size) {
            if (tokens[i].length == 1 &&
                    (tokens[i][0] == '+' || tokens[i][0] == '-' || tokens[i][0] == '*' || tokens[i][0] == '/')) {
                val second = numStack.pop()
                val first = numStack.pop()

                if (tokens[i][0] == '+') numStack.push(first + second)
                if (tokens[i][0] == '-') numStack.push(first - second)
                if (tokens[i][0] == '*') numStack.push(first * second)
                if (tokens[i][0] == '/') numStack.push(first / second)
            } else {
                numStack.push(Integer.parseInt(tokens[i]))
            }
        }
        return numStack.peek()
    }
}

fun main(args: Array<String>) {
    println(Solution().evalRPN(arrayOf("2", "1", "+", "3", "*")))
    println(Solution().evalRPN(arrayOf("4", "13", "5", "/", "+")))
    println(Solution().evalRPN(arrayOf("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+")))
}