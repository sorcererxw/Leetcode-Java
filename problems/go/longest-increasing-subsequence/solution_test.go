package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestLengthOfLIS(t *testing.T) {
	t.Run("", func(t *testing.T) {
		assert.Equal(t, 4, lengthOfLIS([]int{10, 9, 2, 5, 3, 7, 101, 18}))
	})
	t.Run("", func(t *testing.T) {
		assert.Equal(t, 4, lengthOfLIS([]int{0, 1, 0, 3, 2, 3}))
	})
	t.Run("", func(t *testing.T) {
		assert.Equal(t, 1, lengthOfLIS([]int{7, 7, 7, 7, 7, 7, 7}))
	})
	t.Run("", func(t *testing.T) {
		assert.Equal(t, 6, lengthOfLIS([]int{3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12}))
	})
}
