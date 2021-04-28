package solution._406_Queue_Reconstruction_by_Height

/**
 * @author: Sorcerer
 * @date: 2/16/2019
 * @description: https://leetcode.com/problems/queue-reconstruction-by-height/
 * 模拟题
 * 先排序
 * 然后依次进行处理，从前到后计算前面有多少个大于等于自己的高度 equalOrLargerThanItCount
 * （因为排序了，所有即使是空的槽位，未来一定也是被更高的值填入，所以空槽位也计算进去）
 * 等 equalOrLargerThanItCount 和自己位置一样时，等找到第一个空槽就插入
 */
class Solution {
    fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
        people.sortWith(Comparator { o1, o2 ->
            if (o1[0] == o2[0]) o1[1] - o2[1] else o1[0] - o2[0]
        })
        val size = people.size
        val result: Array<IntArray> = Array(size) { intArrayOf() }
        people.forEach {
            var equalOrLargerThanItCount = 0
            for (idx in 0 until size) {
                if (equalOrLargerThanItCount < it[1]) {
                    if (result[idx].isEmpty() || result[idx][0] >= it[0]) equalOrLargerThanItCount++
                } else if (result[idx].isEmpty()) {
                    result[idx] = it
                    break
                }
            }
        }
        return result
    }
}

fun printResult(result: Array<IntArray>) {
    print("[")
    for (i in 0 until result.size) {
        if (i > 0) print(", ")
        print("[")
        for (j in 0 until result[i].size) {
            if (j > 0) print(", ")
            print(result[i][j])
        }
        print("]")
    }
    print("]")
    println()
}

fun main(args: Array<String>) {
    val result = Solution().reconstructQueue(arrayOf(
            intArrayOf(7, 0),
            intArrayOf(4, 4),
            intArrayOf(7, 1),
            intArrayOf(5, 0),
            intArrayOf(6, 1),
            intArrayOf(5, 2)
    ))
    printResult(result)
}