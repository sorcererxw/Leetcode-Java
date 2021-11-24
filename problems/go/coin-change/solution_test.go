package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func Test_coinChange(t *testing.T) {
	t.Run("", func(t *testing.T) {
		assert.Equal(t, 3, coinChange([]int{1, 2, 5}, 11))
	})
	t.Run("", func(t *testing.T) {
		assert.Equal(t, -1, coinChange([]int{2}, 3))
	})
	t.Run("", func(t *testing.T) {
		assert.Equal(t, 0, coinChange([]int{1}, 0))
	})
	t.Run("", func(t *testing.T) {
		assert.Equal(t, 1, coinChange([]int{1}, 1))
	})
	t.Run("", func(t *testing.T) {
		assert.Equal(t, 2, coinChange([]int{1}, 2))
	})
}
