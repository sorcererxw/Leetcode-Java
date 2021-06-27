package main

func candy(ratings []int) int {
	n := len(ratings)
	left := make([]int, n)
	for i := 0; i < len(left); i++ {
		if i > 0 && ratings[i] > ratings[i-1] {
			left[i] = left[i-1] + 1
		} else {
			left[i] = 1
		}
	}
	right := make([]int, n)
	for i := n - 1; i >= 0; i-- {
		if i < n-1 && ratings[i] > ratings[i+1] {
			right[i] = right[i+1] + 1
		} else {
			right[i] = 1
		}
	}
	var sum int
	for i := 0; i < n; i++ {
		if left[i] > right[i] {
			sum += left[i]
		} else {
			sum += right[i]
		}
	}
	return sum
}
