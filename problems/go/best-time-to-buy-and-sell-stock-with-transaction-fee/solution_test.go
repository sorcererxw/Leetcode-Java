package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func Test_maxProfit(t *testing.T) {
	t.Run("", func(t *testing.T) {
		assert.Equal(t, 8, maxProfit([]int{1, 3, 2, 8, 4, 9}, 2))
	})
	t.Run("", func(t *testing.T) {
		assert.Equal(t, 6, maxProfit([]int{1, 3, 7, 5, 10, 3}, 3))
	})
}
