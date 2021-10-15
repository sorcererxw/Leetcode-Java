package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func Test_shortestSeq(t *testing.T) {
	t.Run("", func(t *testing.T) {
		assert.Equal(t, []int{7, 10}, shortestSeq([]int{7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7}, []int{1, 5, 9}))
	})
	t.Run("", func(t *testing.T) {
		assert.Equal(t, []int{}, shortestSeq([]int{1, 2, 3}, []int{4}))
	})
	t.Run("", func(t *testing.T) {
		assert.Equal(t, []int{0, 2}, shortestSeq([]int{1, 2, 3}, []int{1, 2, 3}))
	})
	t.Run("", func(t *testing.T) {
		assert.Equal(t, []int{1, 8}, shortestSeq([]int{521704, 897261, 279103, 381783, 668374, 934085, 254258, 726184, 496153, 804155}, []int{897261, 934085, 381783, 496153}))
	})
	t.Run("", func(t *testing.T) {
		assert.Equal(t, []int{1, 9}, shortestSeq([]int{210839, 955055, 464216, 284254, 950220, 726098, 609415, 482336, 132771, 282762}, []int{955055, 282762, 132771, 609415}))
	})
}
