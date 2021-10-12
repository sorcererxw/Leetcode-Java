package main

func tribonacci(n int) int {
	dp := make([]int, n+1)
	for i := 0; i <= n; i++ {
		switch i {
		case 0:
		case 1, 2:
			dp[i] = 1
		default:
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3]
		}
	}
	return dp[n]
}
