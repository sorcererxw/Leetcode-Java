package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func Test_trap(t *testing.T) {
	t.Run("", func(t *testing.T) {
		assert.Equal(t, 6, trap([]int{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}))
	})
	t.Run("", func(t *testing.T) {
		assert.Equal(t, 9, trap([]int{4, 2, 0, 3, 2, 5}))
	})
}
