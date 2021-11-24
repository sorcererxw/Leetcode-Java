package main

const inf = 10000000

func min3(a, b, c int) int {
	if a < b && a < c {
		return a
	}
	if b < c {
		return b
	}
	return c
}

func mincostTickets(days []int, costs []int) int {
	const N = 365
	var dp [N + 1 + 30]int
	d := make(map[int]struct{})
	for _, v := range days {
		d[v] = struct{}{}
	}
	for i := N; i >= 0; i-- {
		if _, ok := d[i]; ok {
			dp[i] = min3(dp[i+1]+costs[0], dp[i+7]+costs[1], dp[i+30]+costs[2])
		} else {
			dp[i] = dp[i+1]
		}
	}
	return dp[0]
}
