package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func Test_findLongestChain(t *testing.T) {
	t.Run("", func(t *testing.T) {
		assert.Equal(t, 2, findLongestChain([][]int{{1, 2}, {2, 3}, {3, 4}}))
	})
	t.Run("", func(t *testing.T) {
		assert.Equal(t, 3, findLongestChain([][]int{{1, 2}, {7, 8}, {4, 5}}))
	})
}
