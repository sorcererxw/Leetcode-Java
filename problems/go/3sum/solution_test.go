package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestThreeSum(t *testing.T) {
	assert.Equal(t, [][]int{
		{-1, -1, 2},
		{-1, 0, 1},
	}, threeSum([]int{-1, 0, 1, 2, -1, -4}))
	assert.Equal(t, [][]int{
		{-2, 0, 2},
	}, threeSum([]int{-2, 0, 0, 2, 2}))
}
