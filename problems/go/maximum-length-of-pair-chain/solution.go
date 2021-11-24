package main

import (
	"sort"
)

func findLongestChain(pairs [][]int) int {
	sort.Slice(pairs, func(i, j int) bool {
		if pairs[i][0] == pairs[j][0] {
			return pairs[i][1] < pairs[j][1]
		}
		return pairs[i][0] < pairs[j][0]
	})
	dp := make([]int, len(pairs))
	for i := 0; i < len(pairs); i++ {
		dp[i] = 1
		for j := 0; j < i; j++ {
			if pairs[j][1] >= pairs[i][0] {
				continue
			}
			if dp[i] == 0 || dp[j]+1 > dp[i] {
				dp[i] = dp[j] + 1
			}
		}
	}
	var max int
	for _, v := range dp {
		if v > max {
			max = v
		}
	}
	return max
}
