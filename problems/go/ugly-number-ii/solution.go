package main

func min(a, b int) int {
	if a > b {
		return b
	}
	return a
}

func nthUglyNumber(n int) int {
	dp := make([]int, n+1)
	dp[1] = 1
	p2, p3, p5 := 1, 1, 1
	for i := 2; i <= n; i++ {
		k2, k3, k5 := dp[p2]*2, dp[p3]*3, dp[p5]*5
		dp[i] = min(min(k2, k3), k5)
		if dp[i] == k2 {
			p2++
		}
		if dp[i] == k3 {
			p3++
		}
		if dp[i] == k5 {
			p5++
		}
	}
	return dp[n]
}
