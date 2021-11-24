package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func Test_networkDelayTime(t *testing.T) {
	t.Run("", func(t *testing.T) {
		assert.Equal(t, 2, networkDelayTime([][]int{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2))
	})
	t.Run("", func(t *testing.T) {
		assert.Equal(t, 1, networkDelayTime([][]int{{1, 2, 1}}, 2, 1))
	})
	t.Run("", func(t *testing.T) {
		assert.Equal(t, -1, networkDelayTime([][]int{{1, 2, 1}}, 2, 2))
	})
}
