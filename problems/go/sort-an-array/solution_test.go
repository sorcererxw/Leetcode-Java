package main

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestSortArray(t *testing.T) {
	var cases = []struct {
		input  []int
		expect []int
	}{
		{
			[]int{3, 2, 1, 5, 6, 4},
			[]int{1, 2, 3, 4, 5, 6},
		},
	}
	for _, c := range cases {
		c := c
		t.Run("", func(t *testing.T) {
			assert.Equal(t, c.expect, sortArray(c.input))
		})
	}
}
