package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func Test_multiply(t *testing.T) {
	t.Run("", func(t *testing.T) {
		assert.Equal(t, 10, multiply(1, 10))
	})
	t.Run("", func(t *testing.T) {
		assert.Equal(t, 12, multiply(3, 4))
	})
}
