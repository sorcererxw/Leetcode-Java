package main

func min(a int, b int) int {
	if a < b {
		return a
	}
	return b
}

func minCostClimbingStairs(cost []int) int {
	dp := make([]int, len(cost))
	for i := 0; i < len(cost); i++ {
		switch i {
		case 0, 1:
			dp[i] = cost[i]
		default:
			dp[i] = min(dp[i-1], dp[i-2]) + cost[i]
		}
	}
	return min(dp[len(cost)-1], dp[len(cost)-2])
}
