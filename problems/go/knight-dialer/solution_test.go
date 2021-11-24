package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func Test_knightDialer(t *testing.T) {
	t.Run("", func(t *testing.T) {
		assert.Equal(t, 10, knightDialer(1))
	})
	t.Run("", func(t *testing.T) {
		assert.Equal(t, 20, knightDialer(2))
	})
	t.Run("", func(t *testing.T) {
		assert.Equal(t, 46, knightDialer(3))
	})
	t.Run("", func(t *testing.T) {
		assert.Equal(t, 136006598, knightDialer(3131))
	})
}
