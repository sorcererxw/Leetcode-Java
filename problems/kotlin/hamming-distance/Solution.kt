package solution._461_Hamming_Distance

/**
 * @author: Sorcerer
 * @date: 2/17/2019
 * @description: https://leetcode.com/problems/hamming-distance/
 */

class Solution {
    fun hammingDistance(x: Int, y: Int): Int {
        var z = x xor y
        var cnt = 0
        while (z > 0) {
            if ((z and 1) == 1) cnt++
            z = z shr 1
        }
        return cnt
    }
}

fun main(args: Array<String>) {
    println(Solution().hammingDistance(1, 4))
}