package solution._438_Find_All_Anagrams_in_a_String

import java.util.*
import kotlin.collections.ArrayList

/**
 * @author: Sorcerer
 * @date: 2/14/2019
 * @description: https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * 滑动窗口
 */
class Solution {
    fun findAnagrams(s: String, p: String): List<Int> {
        val queue: Queue<Char> = LinkedList()
        val result: MutableList<Int> = ArrayList()
        val dic = IntArray(256) { -1 }
        p.forEach {
            val key = it.toInt()
            if (dic[key] == -1) dic[key] = 1
            else dic[key]++
        }
        for (i in 0 until s.length) {

            if (queue.size == p.length) result.add(i - p.length)
            if (queue.size > 0) {
                val top = queue.remove()
                if (dic[top.toInt()] != -1) {
                    dic[top.toInt()]++
                }
            }
        }
        return result
    }
}