package solution._347_Top_K_Frequent_Elements

import java.util.*

/**
 * @author: Sorcerer
 * @date: 2/22/2019
 * @description: https://leetcode.com/problems/top-k-frequent-elements/
 * 先记录每个值得数目
 * 运用堆（优先队列），把数据进行排序，剔除不符合的数据
 */
class Solution {
    fun topKFrequent(nums: IntArray, k: Int): List<Int> {
        val map: MutableMap<Int, Int> = HashMap()
        nums.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }
        val heap = PriorityQueue<Int> { o1, o2 -> map[o1]!! - map[o2]!! } // 小的先踢出去
        map.keys.forEach {
            heap.add(it)
            if (heap.size > k) heap.poll()
        }
        return heap.toList().sortedWith(Comparator { o1, o2 -> -map[o1]!! + map[o2]!! }) // 大的放在前面
    }
}

fun main(args: Array<String>) {
    println(Solution().topKFrequent(intArrayOf(1, 1, 1, 2, 2, 3), 2))
}