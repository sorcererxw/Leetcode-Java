package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func Test_searchMatrix(t *testing.T) {
	t.Run("", func(t *testing.T) {
		assert.Equal(t, true,
			searchMatrix([][]int{
				{1, 3, 5, 7},
				{10, 11, 16, 20},
				{23, 30, 34, 60},
			}, 3),
		)
	})
	t.Run("", func(t *testing.T) {
		assert.Equal(t, false,
			searchMatrix([][]int{
				{1, 3, 5, 7},
				{10, 11, 16, 20},
				{23, 30, 34, 60},
			}, 13),
		)
	})
}
