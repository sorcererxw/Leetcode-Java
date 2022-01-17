package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestLongestUnivaluePath(t *testing.T) {
	t.Run("", func(t *testing.T) {
		v := longestUnivaluePath(&TreeNode{
			Val: 1,
		})
		assert.Equal(t, 0, v)
	})
	t.Run("", func(t *testing.T) {
		v := longestUnivaluePath(&TreeNode{
			Val: 5,
			Left: &TreeNode{
				Val: 4,
				Left: &TreeNode{
					Val: 1,
				},
				Right: &TreeNode{
					Val: 1,
				},
			},
			Right: &TreeNode{
				Val: 5,
				Right: &TreeNode{
					Val: 5,
				},
			},
		})
		assert.Equal(t, 2, v)
	})
	t.Run("", func(t *testing.T) {
		v := longestUnivaluePath(&TreeNode{
			Val: 1,
			Left: &TreeNode{
				Val: 4,
				Left: &TreeNode{
					Val: 4,
				},
				Right: &TreeNode{
					Val: 4,
				},
			},
			Right: &TreeNode{
				Val: 5,
				Right: &TreeNode{
					Val: 5,
				},
			},
		})
		assert.Equal(t, 2, v)
	})
}
