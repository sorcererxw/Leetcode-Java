package solution._210_Course_Schedule_II

import java.util.*

/**
 * @author: Sorcerer
 * @date: 2/20/2019
 * @description: https://leetcode.com/problems/course-schedule-ii/
 * 同 207
 */
class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val map: Array<BooleanArray> = Array(numCourses) { BooleanArray(numCourses) { false } }
        val inDegree: IntArray = IntArray(numCourses) { 0 }
        val queue: Queue<Int> = LinkedList()
        for (prerequisite in prerequisites) {
            map[prerequisite[1]][prerequisite[0]] = true
            inDegree[prerequisite[0]]++
        }
        for (i in 0 until numCourses) {
            if (inDegree[i] == 0) queue.offer(i)
        }
        var count = 0
        var resultIdx = 0
        val result: IntArray = IntArray(numCourses)
        while (queue.isNotEmpty()) {
            val course = queue.poll()
            result[resultIdx++] = course
            count++
            for (i in 0 until numCourses) {
                if (!map[course][i]) continue
                map[course][i] = false
                inDegree[i]--
                if (inDegree[i] == 0) queue.offer(i)
            }
        }
        if (count != numCourses) return intArrayOf()
        return result
    }
}

fun main(args: Array<String>) {
    val result = Solution().findOrder(4, arrayOf(
            intArrayOf(1, 0),
            intArrayOf(2, 0),
            intArrayOf(3, 1),
            intArrayOf(3, 2)
    )).toList()

    println(result)
}