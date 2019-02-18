package solution._78_Subsets

import java.util.*

/**
 * @author: Sorcerer
 * @date: 2/18/2019
 * @description: https://leetcode.com/problems/subsets/
 */
class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val queue: Queue<List<Int>> = LinkedList()
        queue.offer(emptyList())
        nums.forEach { num ->
            var size = queue.size
            while (size-- > 0) {
                val top = queue.remove()
                queue.offer(top)
                val new = top.toMutableList()
                new.add(num)
                queue.offer(new)
            }
        }
        return queue as LinkedList
    }
}

fun main(args: Array<String>) {
    println(Solution().subsets(intArrayOf(1, 2, 3)))
}