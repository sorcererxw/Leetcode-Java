package largest_plus_sign

func orderOfLargestPlusSign(n int, mines [][]int) (ans int) {
	dp := make([][]int16, n)
	for i := 0; i < n; i++ {
		dp[i] = make([]int16, n)
	}

	set := make(map[int]struct{})
	for i := 0; i < len(mines); i++ {
		set[mines[i][0]*n+mines[i][1]] = struct{}{}
	}
	for i := 0; i < n; i++ {
		var t int16
		for j := 0; j < n; j++ {
			if _, ok := set[i*n+j]; ok {
				t = 0
			} else {
				t += 1
			}
			dp[i][j] = t
		}
		t = 0
		for j := n - 1; j >= 0; j-- {
			if _, ok := set[i*n+j]; ok {
				t = 0
			} else {
				t += 1
			}
			if t < dp[i][j] {
				dp[i][j] = t
			}
		}
	}
	for j := 0; j < n; j++ {
		var t int16
		for i := 0; i < n; i++ {
			if _, ok := set[i*n+j]; ok {
				t = 0
			} else {
				t += 1
			}
			if t < dp[i][j] {
				dp[i][j] = t
			}
		}
		t = 0
		for i := n - 1; i >= 0; i-- {
			if _, ok := set[i*n+j]; ok {
				t = 0
			} else {
				t += 1
			}
			if t < dp[i][j] {
				dp[i][j] = t
			}
			if v := int(dp[i][j]); v > ans {
				ans = v
			}
		}
	}
	return
}
