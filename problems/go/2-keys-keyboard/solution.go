package main

func minSteps(n int) int {
	dp := make([]int, n+1)
	for i := 2; i <= n; i++ {
		for j := 1; j < i; j++ {
			if i%j != 0 {
				continue
			}
			if v := dp[j] + i/j; dp[i] == 0 || v < dp[i] {
				dp[i] = v
			}
		}
	}
	return dp[n]
}
