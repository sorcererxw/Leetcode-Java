package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestGetLeastNumbers(t *testing.T) {
	t.Run("", func(t *testing.T) {
		assert.Equal(t, []int{2, 1}, getLeastNumbers([]int{3, 2, 1}, 2))
	})
	t.Run("", func(t *testing.T) {
		assert.Equal(t, []int{0}, getLeastNumbers([]int{0, 1, 2, 1}, 1))
	})
	t.Run("", func(t *testing.T) {
		assert.Equal(t, []int{}, getLeastNumbers([]int{0, 1, 2, 1}, 0))
	})
}
