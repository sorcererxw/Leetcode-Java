package main

func dieSimulator(n int, rollMax []int) int {
	dp := make([][][]int, n+1)

	for i := 0; i <= n; i++ {
		for j := 0; j < 6; j++ {

			for k := 2; k <= rollMax[j]; k++ {
				dp[i][j][k] = dp[i-1][j][k-1]
			}
		}
	}
}

// dfs(n, rollMax, -1, 0)
func dfs(n int, rollMax []int, last int, consecutive int) int {
	if n == 0 {
		return 1
	}
	var sum int
	for i := 0; i < 6; i++ {
		if last == i {
			if consecutive == rollMax[i] {
				continue
			}
			sum += dfs(n-1, rollMax, i, consecutive+1)
		} else {
			sum += dfs(n-1, rollMax, i, 1)
		}
	}
	return sum
}
