package solution._224_Basic_Calculator

import util.println
import java.util.*

/**
 * @author: sorcererxw
 * @date: 2019/4/2
 * @description:
 */
class Solution {
    fun calculate(s: String): Int {
        var num = -1
        val numStack = Stack<Int>()
        val opStack = Stack<Int>()
        for (i in 0 until s.length) {
            if (s[i] == ' ') continue
            else if (s[i].isDigit()) {
                if (num < 0) num = 0
                num = num * 10 + (s[i] - '0')
            } else if (s[i] == '+' || s[i] == '-' || s[i] == '(') {
                if (num >= 0) {
                    numStack.push(num)
                    num = -1
                }
                opStack.push(when {
                    s[i] == '+' -> 1
                    s[i] == '-' -> -1
                    else -> 0
                })
            } else if (s[i] == ')') {
                if (num >= 0) {
                    numStack.push(num)
                    num = -1
                }
                var sum = 0
                while (opStack.peek() != 0) {
                    sum += opStack.pop() * numStack.pop()
                }
                sum += numStack.pop()
                opStack.pop()
                numStack.push(sum)
            }
        }
        if (num >= 0) {
            numStack.push(num)
            num = -1
        }
        var sum = 0
        while (opStack.isNotEmpty()) {
            sum += opStack.pop() * numStack.pop()
        }
        sum += numStack.pop()
        return sum
    }
}

fun main() {
    Solution().calculate("1+  1").println()
    Solution().calculate(" 2-1 + 2 ").println()
    Solution().calculate("(1+(4+5+2)-3)+(6+8)").println()
    Solution().calculate("101-32").println()

}