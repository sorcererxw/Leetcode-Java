package main

import (
	"testing"

	"github.com/stretchr/testify/require"
)

func Test_numUniqueEmails(t *testing.T) {
	t.Run("", func(t *testing.T) {
		require.Equal(t, 1, numUniqueEmails([]string{"test.email+alex@leetcode.com", "test.email@leetcode.com"}))
	})
}
