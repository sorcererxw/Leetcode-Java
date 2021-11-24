package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func Test_canPartition(t *testing.T) {
	t.Run("", func(t *testing.T) {
		assert.Equal(t, true, canPartition([]int{1, 5, 11, 5}))
	})

	t.Run("", func(t *testing.T) {
		assert.Equal(t, false, canPartition([]int{1, 2, 3, 5}))
	})
}
