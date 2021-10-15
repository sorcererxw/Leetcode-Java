package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func Test_twoSum(t *testing.T) {
	t.Run("", func(t *testing.T) {
		assert.Equal(t, []int{0, 1}, twoSum([]int{2, 7, 11, 15}, 9))
	})
	t.Run("", func(t *testing.T) {
		assert.Equal(t, []int{1, 2}, twoSum([]int{3, 2, 4}, 6))
	})
	t.Run("", func(t *testing.T) {
		assert.Equal(t, []int{0, 1}, twoSum([]int{3, 3}, 6))
	})
	t.Run("", func(t *testing.T) {
		assert.Equal(t, []int{0, 2}, twoSum([]int{3, 2, 3}, 6))
	})
}
