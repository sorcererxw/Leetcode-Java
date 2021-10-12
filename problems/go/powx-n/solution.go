package main

func myPow(x float64, n int) float64 {
	if n == 0 {
		return 1
	}
	if n < 0 {
		return float64(1) / myPow(x, -n)
	}
	ans := float64(1)
	for n > 0 {
		if n%2 == 0 {
			x *= x
			n /= 2
		} else {
			ans *= x
			n -= 1
		}
	}
	return ans
}
