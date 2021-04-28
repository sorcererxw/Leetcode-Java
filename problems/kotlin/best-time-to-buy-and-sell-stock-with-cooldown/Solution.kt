package solution._309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown

/**
 * @author: Sorcerer
 * @date: 2/17/2019
 * @description: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 */
class Solution {
    fun maxProfit(prices: IntArray): Int {
        if (prices.size < 2) return 0
        val rest = IntArray(prices.size) { 0 }
        val buy = IntArray(prices.size) { 0 }
        val sell = IntArray(prices.size) { 0 }
        rest[0] = 0
        buy[0] = -prices[0]
        sell[0] = Int.MIN_VALUE
        /**
         * 因为永远只用得到 i-1 时的状态值，所以可以将 O(n）的空间压缩到 O(1）
         */
        for (i in 1 until prices.size) {
            rest[i] = Math.max(rest[i - 1], sell[i - 1])
            buy[i] = Math.max(buy[i - 1], rest[i - 1] - prices[i]) // 如果状态休息变成已购买，就要扣钱。如果状态没变就不扣钱
            sell[i] = buy[i - 1] + prices[i] // 钱是在已购买到已售出这个状态转移时增加的，不是已售出到休息这个过程中
        }
        return Math.max(sell[prices.size - 1], rest[prices.size - 1])
    }
}

fun main(args: Array<String>) {
    val result = Solution().maxProfit(intArrayOf(1,2,3,0,2))
    println(result)
}