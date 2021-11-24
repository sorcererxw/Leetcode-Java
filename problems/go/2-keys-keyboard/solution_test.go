package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func Test_minSteps(t *testing.T) {
	t.Run("", func(t *testing.T) {
		assert.Equal(t, 3,minSteps(3))
	})
	t.Run("", func(t *testing.T) {
		assert.Equal(t, 0,minSteps(1))
	})
}
