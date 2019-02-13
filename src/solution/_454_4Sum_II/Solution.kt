package solution._454_4Sum_II

/**
 * @author: Sorcerer
 * @date: 2/13/2019
 * @description: https://leetcode.com/problems/4sum-ii/
 * a + b + c + d = 0 有多少种组合
 * 只需要计算出 a+b 有多少种组合， c+d 有多少种组合， 比对一下就可以得出， O(n^2)
 */
class Solution {
    fun fourSumCount(A: IntArray, B: IntArray, C: IntArray, D: IntArray): Int {
        var count = 0
        val map: MutableMap<Int, Int> = HashMap()
        A.forEach { a ->
            B.forEach { b ->
                val key = a + b
                map[key] = map.getOrDefault(key, 0) + 1
            }
        }
        C.forEach { c ->
            D.forEach { d ->
                count += map.getOrDefault(-c - d, 0)
            }
        }
        return count
    }
}

fun main(args: Array<String>) {
    val result = Solution().fourSumCount(
            intArrayOf(1, 2),
            intArrayOf(-2, -1),
            intArrayOf(-1, 2),
            intArrayOf(0, 2)
    )
    println(result)
}