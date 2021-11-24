package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func Test_change(t *testing.T) {
	t.Run("", func(t *testing.T) {
		assert.Equal(t, 4, change(5, []int{1, 2, 5}))
	})
	t.Run("", func(t *testing.T) {
		assert.Equal(t, 0, change(3, []int{2}))
	})
	t.Run("", func(t *testing.T) {
		assert.Equal(t, 1, change(10, []int{10}))
	})
}
