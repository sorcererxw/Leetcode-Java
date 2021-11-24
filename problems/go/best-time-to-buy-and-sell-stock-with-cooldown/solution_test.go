package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func Test_maxProfit(t *testing.T) {
	t.Run("", func(t *testing.T) {
		assert.Equal(t, 3, maxProfit([]int{1, 2, 3, 0, 2}))
	})
	t.Run("", func(t *testing.T) {
		assert.Equal(t, 0, maxProfit([]int{1}))
	})
}
