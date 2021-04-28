package _1475

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func Test(t *testing.T) {
	cases := []struct {
		Input  []int
		Output []int
	}{
		{[]int{8, 4, 6, 2, 3}, []int{4, 2, 4, 2, 3}},
		{[]int{1, 2, 3, 4, 5}, []int{1, 2, 3, 4, 5}},
		{[]int{10, 1, 1, 6}, []int{9, 0, 1, 6}},
	}
	for _, c := range cases {
		assert.Equal(t, c.Output, finalPrices(c.Input))
	}
}
