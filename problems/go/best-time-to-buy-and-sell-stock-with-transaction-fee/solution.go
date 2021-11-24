package main

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func maxProfit(prices []int, fee int) int {
	dp := [2]int{0, -prices[0]}
	for i := 1; i < len(prices); i++ {
		dp[0], dp[1] = max(dp[0], dp[1]+prices[i]-fee), max(dp[1], dp[0]-prices[i])
	}
	return max(dp[0], dp[1])
}
