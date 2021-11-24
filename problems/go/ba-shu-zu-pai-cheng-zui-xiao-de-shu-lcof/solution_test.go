package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func Test_minNumber(t *testing.T) {
	t.Run("", func(t *testing.T) {
		assert.Equal(t, "3033459", minNumber([]int{3, 30, 34, 5, 9}))
	})
}
