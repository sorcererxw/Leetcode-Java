package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func Test_numSquares(t *testing.T) {
	t.Run("", func(t *testing.T) {
		assert.Equal(t, 3, numSquares(12))
	})
	t.Run("", func(t *testing.T) {
		assert.Equal(t, 2, numSquares(13))
	})
}
