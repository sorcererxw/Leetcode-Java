package solution._121_Best_Time_to_Buy_and_Sell_Stock

/**
 * @author: Sorcerer
 * @date: 2/14/2019
 * @description: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
class Solution {
    fun maxProfit(prices: IntArray): Int {
        if(prices.isEmpty())return 0
        var min = prices[0]
        var result = 0
        prices.forEach { p ->
            if (result < (p - min)) result = p - min
            if (min > p) min = p
        }
        return result
    }
}