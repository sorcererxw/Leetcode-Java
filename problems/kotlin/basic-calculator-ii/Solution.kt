package solution._227_Basic_Calculator_II

import java.util.*

/**
 * @author: Sorcerer
 * @date: 2/20/2019
 * @description: https://leetcode.com/problems/basic-calculator-ii/
 * 模拟
 * 每次记录上一次的操作符，如果再一次遇到操作符
 * 就拿出上一次的操作符，从栈内拿出上一次的数字，和最新的数字组合
 * 然后将新的操作符记录下来
 */
class Solution {
    fun calculate(s: String): Int {
        if (s.isEmpty()) return 0
        val numStack: Stack<Int> = Stack()

        var num = 0
        var op = '+'
        for (i in 0 until s.length) {
            if (s[i] in '0'..'9') {
                num = num * 10 + (s[i] - '0')
            }
            if (s[i] == '+' || s[i] == '-' || s[i] == '*' || s[i] == '/' || i==s.length-1) {
                if (op == '+') numStack.push(num)
                if (op == '-') numStack.push(-num)
                if (op == '*') numStack.push(numStack.pop() * num)
                if (op == '/') numStack.push(numStack.pop() / num)
                op = s[i]
                num = 0
            }
        }

        return numStack.sum()
    }
}

fun main(args: Array<String>) {
    val testCase = arrayOf(
            "1-1+1",
            "0-2147483647",
            "100*3+2",
            "3/2",
            "3+2*2",
            "3+5 / 2"
    )
    testCase.forEach {
        println("$it = ${Solution().calculate(it)}")
    }

}