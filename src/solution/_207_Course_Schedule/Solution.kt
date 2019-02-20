package solution._207_Course_Schedule

import java.util.*

/**
 * @author: Sorcerer
 * @date: 2/20/2019
 * @description: https://leetcode.com/problems/course-schedule/
 * 找环, 使用 BFS 进行拓扑排序
 */
class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val map: Array<BooleanArray> = Array(numCourses) { BooleanArray(numCourses) { false } }
        val inDegree: IntArray = IntArray(numCourses) { 0 }
        val queue: Queue<Int> = LinkedList()
        for (prerequisite in prerequisites) {
            map[prerequisite[0]][prerequisite[1]] = true
            inDegree[prerequisite[1]]++
        }
        for (i in 0 until numCourses) {
            if (inDegree[i] == 0) queue.offer(i)
        }
        var count = 0
        while (queue.isNotEmpty()) {
            val course = queue.poll()
            count++
            for (i in 0 until numCourses) {
                if (!map[course][i]) continue
                map[course][i] = false
                inDegree[i]--
                if (inDegree[i] == 0) queue.offer(i)
            }
        }
        return count == numCourses
    }
}

fun main(args: Array<String>) {
    println(Solution().canFinish(2, arrayOf(
            intArrayOf(1, 0),
            intArrayOf(0, 1)
    )))
}