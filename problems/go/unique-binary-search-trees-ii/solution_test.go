package _95_unique_binary_search_trees_ii

import (
	"testing"
)

func Test_generateTrees(t *testing.T) {
	t.Run("3", func(t *testing.T) {
		trees := generateTrees(3)
		for _, tree := range trees {
			t.Log(tree.PreOrderTraversal())
		}
	})
}
