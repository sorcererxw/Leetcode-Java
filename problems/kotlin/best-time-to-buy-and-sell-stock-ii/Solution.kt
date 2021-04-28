package solution._122_Best_Time_to_Buy_and_Sell_Stock_II

/**
 * @author: Sorcerer
 * @date: 2/20/2019
 * @description: 122. Best Time to Buy and Sell Stock II
 * 贪心算法
 * 假设 day1<day2<day3<day4
 * 那么这四天最大总收益一定是 day4-day1
 * day4-day1 > (day2-day1 + day4-day3)
 * 那么 day4-day1 = day2-day1 + day3-day2 +day4-day3
 * day1~day4组成了一个上升曲线
 * 那么所有上升曲线之和就是此题的解
 */

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var profit = 0
        for (i in 1 until prices.size) {
            if (prices[i] > prices[i - 1]) {
                profit += (prices[i] - prices[i - 1])
            }
        }
        return profit
    }
}
