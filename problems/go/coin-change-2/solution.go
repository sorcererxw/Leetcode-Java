package main

import (
	"sort"
)

func change(amount int, coins []int) int {
	sort.Slice(coins, func(i, j int) bool { return coins[i] < coins[j] })
	dp := make([][]int, amount+1)
	for i := range dp {
		dp[i] = make([]int, len(coins)+1)
	}
	for i := range dp[0] {
		dp[0][i] = 1
	}
	// dp[i][j] = dp[i][j-1] + i>coins[j-1]?dp[i-coins[j-1]][j]
	// 当前的数目 = 更少的 coin 方案 + 满 coin 方案(满 coin 前提是当前 coin 大于 amount)
	for i := 1; i <= amount; i++ {
		for j := 1; j <= len(coins); j++ {
			dp[i][j] = dp[i][j-1]
			if i >= coins[j-1] {
				dp[i][j] += dp[i-coins[j-1]][j]
			}
		}
	}
	return dp[amount][len(coins)]
}
