package main

func climbStairs(n int) int {
	dp := make([]int, n+1)
	for i := 0; i <= n; i++ {
		switch i {
		case 0:
			dp[i] = 1
		case 1:
			dp[i] = 1
		default:
			dp[i] = dp[i-1] + dp[i-2]
		}
	}
	return dp[n]
}
