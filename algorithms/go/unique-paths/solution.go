package _62_Unique_Paths

// A_(m-1+n-1)^(n-1)
func uniquePaths(m int, n int) int {
	k := m
	if n < m {
		k = n
	}
	k -= 1
	up := 1
	bottom := 1
	for i := 1; i <= k; i++ {
		up *= m - 1 + n - i
		bottom *= i
	}
	return up / bottom
}
