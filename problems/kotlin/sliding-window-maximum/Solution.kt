package solution._239_Sliding_Window_Maximum

import util.println
import java.util.*

/**
 * @author: Sorcerer
 * @date: 2/26/2019
 * @description: https://leetcode.com/problems/sliding-window-maximum/
 * 双向队列
 */
class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        if (k < 0) return intArrayOf()

        val maxList: MutableList<Int> = ArrayList()
        val deque: Deque<Int> = LinkedList() // 存放下标，通过存放下标对值进行唯一化
        for (i in 0 until nums.size) {
            while (deque.isNotEmpty() && deque.peekFirst() < i - k + 1) {
                deque.removeFirst()
            }
            while (deque.isNotEmpty() && nums[deque.peekLast()] < nums[i]) { // 从后到前删除所有小于当前值的
                deque.removeLast()
            }
            deque.addLast(i)

            if (i >= k - 1) {
                maxList.add(nums[deque.peekFirst()])
            }
        }
        return maxList.toIntArray()
    }
}

fun main(args: Array<String>) {
    Solution().maxSlidingWindow(intArrayOf(1, 3, -1, -3, 5, 3, 6, 7), 3).println()
}