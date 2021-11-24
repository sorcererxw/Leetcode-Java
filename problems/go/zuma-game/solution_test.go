package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func Test_findMinStep(t *testing.T) {
	t.Run("", func(t *testing.T) {
		assert.Equal(t, -1, findMinStep("WRRBBW", "RB"))
	})
	t.Run("", func(t *testing.T) {
		assert.Equal(t, 2, findMinStep("WWRRBBWW", "WRBRW"))
	})
	t.Run("", func(t *testing.T) {
		assert.Equal(t, 2, findMinStep("G", "GGGGG"))
	})
}
