package main

func intPow(n int) int {
	N := 1
	for i := 0; i < n; i++ {
		N *= 2
	}
	return N
}

func grayCode(n int) []int {
	arr := make([]int, intPow(n))
	for i := 1; i <= n; i++ {
		pow := intPow(i)
		for j := pow / 2; j < pow; j++ {
			arr[j] = arr[pow-1-j] + pow/2
		}
	}
	return arr
}
