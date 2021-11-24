package main

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func maxProfit(prices []int) int {
	if len(prices) == 0 {
		return 0
	}
	dp := [3]int{-prices[0]}
	for i := 1; i < len(prices); i++ {
		dp[0], dp[1], dp[2] = max(dp[0], dp[2]-prices[i]), dp[0]+prices[i], max(dp[1], dp[2])
	}
	return max(dp[2], dp[1])
}
