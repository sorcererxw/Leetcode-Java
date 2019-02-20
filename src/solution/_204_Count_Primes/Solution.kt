package solution._204_Count_Primes

/**
 * @author: Sorcerer
 * @date: 2/20/2019
 * @description: https://leetcode.com/problems/count-primes/
 * 素数筛
 */
class Solution {
    fun countPrimes(n: Int): Int {
        if (n <= 1) return 0
        val primes = BooleanArray(n ) { true }
        primes[0] = false
        primes[1] = false
        var count = 0
        for (i in 2 until n) {
            if (!primes[i]) continue
            count++
            for (j in i until n step i) {
                if (j != i) primes[j] = false
            }
        }
        return count
    }
}

fun main(args: Array<String>) {
    println(Solution().countPrimes(10))
}