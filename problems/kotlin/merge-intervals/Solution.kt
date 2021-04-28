package solution._56_Merge_Intervals

import java.util.*

/**
 * @author: Sorcerer
 * @date: 2/21/2019
 * @description: https://leetcode.com/problems/merge-intervals/
 * 先排序，然后扫描一遍，根据起点依次合并
 * 为了尽量少使用空间，使用linkedList作为栈
 * 或者不使用栈，直接在last上做修改
 */

class Solution {
    fun merge(intervals: List<Interval>): List<Interval> {
        Collections.sort(intervals) { o1, o2 ->
            if (o1.start != o2.start) o1.start - o2.start
            else o2.end - o2.end
        }
        val stack: LinkedList<Interval> = LinkedList()
        for (interval in intervals) {
            if (stack.isEmpty()) stack.addLast(interval)
            val last = stack.last
            if (interval.start in last.start..last.end) {
                stack.pollLast()
                stack.addLast(Interval(last.start, Math.max(interval.end, last.end)))
            } else {
                stack.addLast(interval)
            }
        }
        return stack
    }
}

fun main(args: Array<String>) {
    Solution().merge(listOf(
            Interval(1, 3),
            Interval(2, 6),
            Interval(8, 10),
            Interval(15, 18)
    )).forEach { println(it.toString()) }
}

data class Interval(
        var start: Int = 0,
        var end: Int = 0
)