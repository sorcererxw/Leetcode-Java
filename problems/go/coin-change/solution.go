package main

func coinChange(coins []int, amount int) int {
	if amount==0 {
		return 0
	}
	dp := make([]int, amount+1)
	for _, c := range coins {
		if c <= amount {
			dp[c] = 1
		}
		for i := c; i <= amount; i++ {
			if dp[i-c] == 0 {
				continue
			}
			if dp[i] == 0 || dp[i] > dp[i-c] {
				dp[i] = dp[i-c] + 1
			}
		}
	}
	if dp[amount] == 0 {
		return -1
	}
	return dp[amount]
}
