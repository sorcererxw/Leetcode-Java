package main

func multiply(A int, B int) int {
	var ans int
	if B&1 == 1 {
		ans += A
	}
	if B > 1 {
		ans += multiply(A+A, B>>1)
	}
	return ans
}
