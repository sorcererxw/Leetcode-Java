package solution._77_

/**
 * @author: Sorcerer
 * @date: 12/4/2018
 * @description:
 */
class Solution {
    fun combine(n: Int, k: Int): List<List<Int>> {
        if (k == n || k == 0) return listOf(IntArray(k) { it + 1 }.toList())
        return listOf(
                *combine(n - 1, k - 1).map { listOf(n, *it.toTypedArray()) }.toTypedArray(),
                *combine(n - 1, k).toTypedArray()
        )
    }
}

fun main(args: Array<String>) {
    val arr = intArrayOf()
    println(arr::class.java)
    println(arr::class.java.superclass)
}