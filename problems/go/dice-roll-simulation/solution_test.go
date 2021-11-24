package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func Test_dieSimulator(t *testing.T) {
	t.Run("", func(t *testing.T) {
		assert.Equal(t, 30, dieSimulator(2, []int{1, 1, 1, 1, 1, 1}))
	})
	t.Run("", func(t *testing.T) {
		assert.Equal(t, 34, dieSimulator(2, []int{1, 1, 2, 2, 2, 3}))
	})
	t.Run("", func(t *testing.T) {
		assert.Equal(t, 181, dieSimulator(3, []int{1, 1, 1, 2, 2, 3}))
	})
	t.Run("", func(t *testing.T) {
		assert.Equal(t, 0, dieSimulator(20, []int{8, 5, 10, 8, 7, 2}))
	})
}
