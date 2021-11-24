package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func Test_mincostTickets(t *testing.T) {
	t.Run("", func(t *testing.T) {
		assert.Equal(t, 11, mincostTickets([]int{1, 4, 6, 7, 8, 20}, []int{2, 7, 15}))
	})
	t.Run("", func(t *testing.T) {
		assert.Equal(t, 17, mincostTickets([]int{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31}, []int{2, 7, 15}))
	})
	t.Run("", func(t *testing.T) {
		assert.Equal(t, 1, mincostTickets([]int{364}, []int{3, 3, 1}))
	})
}
