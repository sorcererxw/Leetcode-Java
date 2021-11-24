package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func Test_maxLength(t *testing.T) {
	t.Run("", func(t *testing.T) {
		assert.Equal(t, 4, maxLength([]string{"un", "iq", "ue"}))
	})
	t.Run("", func(t *testing.T) {
		assert.Equal(t, 6, maxLength([]string{"cha", "r", "act", "ers"}))
	})
	t.Run("", func(t *testing.T) {
		assert.Equal(t, 26, maxLength([]string{"abcdefghijklmnopqrstuvwxyz"}))
	})
	t.Run("", func(t *testing.T) {
		assert.Equal(t, 0, maxLength([]string{"aa","bb"}))
	})
}
