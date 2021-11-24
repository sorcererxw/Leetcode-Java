package main

func canPartition(nums []int) bool {
	var sum int
	for _, n := range nums {
		sum += n
	}
	if sum%2 != 0 {
		return false
	}
	target := sum / 2
	dp := make([]bool, target+1)
	dp[0] = true
	for _, n := range nums {
		for i := target; i >= n; i-- {
			dp[i] = dp[i] || dp[i-n]
		}
	}
	return dp[target]
}
