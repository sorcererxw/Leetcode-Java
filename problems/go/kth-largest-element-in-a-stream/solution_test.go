package kth_largest_element_in_a_stream

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestKthLargest(t *testing.T) {
	t.Run("", func(t *testing.T) {
		k := Constructor(3, []int{4, 5, 8, 2})
		assert.Equal(t, 4, k.Add(3))
		assert.Equal(t, 5, k.Add(5))
		assert.Equal(t, 5, k.Add(10))
		assert.Equal(t, 8, k.Add(9))
		assert.Equal(t, 8, k.Add(4))
	})
	t.Run("", func(t *testing.T) {
		k := Constructor(1, []int{})
		assert.Equal(t, -3, k.Add(-3))
		assert.Equal(t, -2, k.Add(-2))
		assert.Equal(t, -2, k.Add(-4))
		assert.Equal(t, 0, k.Add(0))
		assert.Equal(t, 4, k.Add(4))
	})
}
