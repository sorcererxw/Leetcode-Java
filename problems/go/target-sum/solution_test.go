package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func Test_findTargetSumWays(t *testing.T) {
	t.Run("", func(t *testing.T) {
		assert.Equal(t, 5, findTargetSumWays([]int{1, 1, 1, 1, 1}, 3))
	})

	t.Run("", func(t *testing.T) {
		assert.Equal(t, 1, findTargetSumWays([]int{1}, 1))
	})
}
