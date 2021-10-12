package sum_of_square_numbers

import (
	"math"
)

func judgeSquareSum(c int) bool {
	for i := 0; float64(i) <= math.Sqrt(float64(c)); i++ {
		t := c - i*i
		v := math.Sqrt(float64(t))
		if float64(int64(v)) == v {
			return true
		}
	}
	return false
}
