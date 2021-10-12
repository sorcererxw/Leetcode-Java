package main

func kthSmallest(matrix [][]int, k int) int {
	n := len(matrix)
	if n == 0 {
		return 0
	}
	l, r := matrix[0][0], matrix[n-1][n-1]
	for l < r {
		mid := l + (r-l)/2 // 二分，最终逼近为 l==r
		if v := check(matrix, mid, n); v >= k {
			r = mid
		} else {
			l = mid + 1
		}
	}
	return l
}

func check(matrix [][]int, k int, n int) int {
	i := n - 1
	j := 0
	sum := 0
	for i >= 0 && j < n {
		if matrix[i][j] <= k {
			sum += i + 1
			j++
		} else {
			i--
		}
	}
	return sum
}
