package solution._441_

import kotlin.math.sqrt

/**
 * @author: Sorcerer
 * @date: 12/4/2018
 * @description:
 */
class Solution {
    fun arrangeCoins(n: Int): Int {
        return ((sqrt(1.0 + 8 * n.toLong()) - 1) / 2).toInt()
    }
}

fun main(args: Array<String>) {
    println(Solution().arrangeCoins(1804289383))
}