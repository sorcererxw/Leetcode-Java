package main

func waysToStep(n int) int {
	dp := [4]int{1, 1, 2, 4}
	if n < 4 {
		return dp[n]
	}
	for i := 4; i <= n; i++ {
		dp[0], dp[1], dp[2] = dp[1], dp[2], dp[3]
		dp[3] = (dp[2] + dp[1] + dp[0]) % 1000000007
	}
	return dp[3]
}
