package _650_2_Keys_Keyboard

/**
 * @author: SorcererXW
 * @date: 2018/5/15
 * @description:
 */

class Solution {
    private val max: Int = 1005
    private lateinit var prime: IntArray

    private fun initPrime() {
        prime = IntArray(max, { -1 })
        prime[0] = 0
        prime[1] = 0
        for (i in 2 until max) {
            if (prime[i] == -1) {
                prime[i] = 1
                for (j in 2 * i until max step i) {
                    prime[j] = 0
                }
            }
        }
        println(prime.toList())
    }

    private fun minPrimeFactor(n: Int): Int {
        if (prime[n] == 1) return n
        for (i in 0 until max) {
            if (prime[i] == 1 && n % i == 0) {
                return i
            }
        }
        return n
    }

    private fun cal(n: Int): Int {
        if (n <= 1) return n
        val factor = minPrimeFactor(n)
        if (factor == n) {
            return n
        }
        return cal(factor) * n / factor
    }

    fun minSteps(n: Int): Int {
        initPrime()
        return cal(n)
    }
}

fun main(args: Array<String>) {
    println(Solution().minSteps(10))
}
