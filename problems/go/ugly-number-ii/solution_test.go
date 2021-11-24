package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func Test_nthUglyNumber(t *testing.T) {
	t.Run("", func(t *testing.T) {
		assert.Equal(t, 12, nthUglyNumber(10))
	})
	t.Run("", func(t *testing.T) {
		assert.Equal(t, 1, nthUglyNumber(1))
	})
}
