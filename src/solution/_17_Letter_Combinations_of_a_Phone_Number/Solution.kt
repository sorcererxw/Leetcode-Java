package solution._17_Letter_Combinations_of_a_Phone_Number

import java.util.*

/**
 * @author: Sorcerer
 * @date: 2/17/2019
 * @description: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
class Solution {
    fun letterCombinations(digits: String): List<String> {
        val map = arrayOf("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")
        val queue: Queue<String> = LinkedList()
        digits.forEach { digit ->
            val d = digit - '0'
            var size = queue.size
            if (size == 0) {
                map[d].forEach { ch ->
                    queue.offer("$ch")
                }
            } else {
                while (size-- > 0) {
                    val s = queue.remove()
                    map[d].forEach { ch ->
                        queue.offer(s + ch)
                    }
                }
            }
        }
        return queue as LinkedList
    }
}

fun main(args: Array<String>) {
    val result = Solution().letterCombinations("23")
    println(result)
}