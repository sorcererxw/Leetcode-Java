package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

// Example 1:
//
// Input: expression = "2-1-1"
// Output: [0,2]
// Explanation:
// ((2-1)-1) = 0
// (2-(1-1)) = 2
// Example 2:
//
// Input: expression = "2*3-4*5"
// Output: [-34,-14,-10,-10,10]
// Explanation:
// (2*(3-(4*5))) = -34
// ((2*3)-(4*5)) = -14
// ((2*(3-4))*5) = -10
// (2*((3-4)*5)) = -10
// (((2*3)-4)*5) = 10
func Test_diffWaysToCompute(t *testing.T) {
	assert.Equal(t, []int{0, 2}, diffWaysToCompute("2-1-1"))
	assert.Equal(t, sort([]int{-34, -14, -10, -10, 10}), sort(diffWaysToCompute("2*3-4*5")))
}

func sort(a []int) []int {
	for i := 0; i < len(a); i++ {
		for j := i; j < len(a); j++ {
			if a[i] > a[j] {
				a[i], a[j] = a[j], a[i]
			}
		}
	}
	return a
}
