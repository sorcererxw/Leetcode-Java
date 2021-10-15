package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func Test_solveNQueens(t *testing.T) {
	t.Run("1", func(t *testing.T) {
		ans := solveNQueens(1)
		assert.Len(t, ans, 1)
		assert.Contains(t, ans, []string{
			"Q",
		})
	})
	t.Run("2", func(t *testing.T) {
		ans := solveNQueens(2)
		assert.Len(t, ans, 0)
	})
	t.Run("4", func(t *testing.T) {
		ans := solveNQueens(4)
		assert.Len(t, ans, 2)
		assert.Contains(t, ans, []string{
			".Q..",
			"...Q",
			"Q...",
			"..Q.",
		})
		assert.Contains(t, ans, []string{
			"..Q.",
			"Q...",
			"...Q",
			".Q..",
		})
	})
}
