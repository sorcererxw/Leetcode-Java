package main

import (
	"math"
)

/*
x(x+1)/2 = n
1/2*x^2 + 1/2x - n = 0

x =(-1/2 + sqrt(1/4+2n))/1 = (-1+sqrt(1+8n))/2
*/

func arrangeCoins(n int) int {
	return int(math.Sqrt(8.0*float64(n)+1.0)-1) / 2
}
