package _88_Merge_Sorted_Array

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func Test(t *testing.T) {
	cases := []struct {
		num1   []int
		m      int
		num2   []int
		n      int
		except []int
	}{
		{[]int{1, 2, 3, 0, 0, 0}, 3, []int{2, 5, 6}, 3, []int{1, 2, 2, 3, 5, 6}},
		{[]int{4, 5, 6, 0, 0, 0}, 3, []int{1, 2, 3}, 3, []int{1, 2, 3, 4, 5, 6}},
	}

	for _, c := range cases {
		merge(c.num1, c.m, c.num2, c.n)
		assert.Equal(t, c.except, c.num1)
	}

}
