package solution._225_Implement_Stack_using_Queues

import java.util.*

/**
 * @author: sorcererxw
 * @date: 2019/3/31
 * @description:
 */
class MyStack() {

    /** Initialize your data structure here. */
    private var masterQueue: Queue<Int> = LinkedList()
    private var slaveQueue: Queue<Int> = LinkedList()

    /** Push element x onto stack. */
    fun push(x: Int) {
        masterQueue.offer(x)
    }

    /** Removes the element on top of the stack and returns that element. */
    fun pop(): Int {
        if (masterQueue.isEmpty()) return 0
        while (masterQueue.size > 1) {
            slaveQueue.offer(masterQueue.poll())
        }
        val result = masterQueue.poll()
        swapMasterSlave()
        return result
    }

    /** Get the top element. */
    fun top(): Int {
        if (masterQueue.isEmpty()) return 0
        while (masterQueue.size > 1) {
            slaveQueue.offer(masterQueue.poll())
        }
        val result = masterQueue.poll()
        slaveQueue.offer(result)
        swapMasterSlave()
        return result
    }

    /** Returns whether the stack is empty. */
    fun empty(): Boolean {
        return masterQueue.isEmpty()
    }

    private fun swapMasterSlave(){
        val t = masterQueue
        masterQueue = slaveQueue
        slaveQueue = t
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * var obj = MyStack()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.empty()
 */