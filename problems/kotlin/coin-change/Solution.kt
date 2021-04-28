package solution._322_Coin_Change

/**
 * @author: Sorcerer
 * @date: 2/20/2019
 * @description: https://leetcode.com/problems/coin-change/
 */
class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val dp: IntArray = IntArray(amount + 1) { -1 }
        dp[0] = 0
        for (i in 1..amount) {
            for (j in 0 until coins.size) {
                val coin = coins[j]
                if (coin > i) continue
                val pre = dp[i - coin]
                if (pre == -1) continue

                if (dp[i] == -1) dp[i] = pre + 1
                else dp[i] = Math.min(dp[i], pre + 1)

            }
        }
        return dp[amount]
    }
}

fun main(args: Array<String>) {
    println(Solution().coinChange(intArrayOf(1, 2, 5), 11))
    println(Solution().coinChange(intArrayOf(2), 3))
}