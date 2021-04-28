package solution._155_Min_Stack

import java.util.*

/**
 * @author: Sorcerer
 * @date: 2/14/2019
 * @description: https://leetcode.com/problems/min-stack/
 */
class MinStack() {

    /** initialize your data structure here. */
    private val stack = Stack<Int>()
    private val min = Stack<Int>()

    fun push(x: Int) {
        stack.push(x)
        if (min.isEmpty() || min.peek() >= x) min.push(x)
    }

    fun pop() {
        if (stack.isEmpty()) return
        val x = stack.pop()
        if (min.isNotEmpty() && min.peek() == x) min.pop()
    }

    fun top(): Int {
        return stack.peek()
    }

    fun getMin(): Int {
        return min.peek()
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(x)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */