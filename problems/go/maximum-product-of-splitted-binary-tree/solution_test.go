package maximum_product_of_splitted_binary_tree

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func Test_maxProduct(t *testing.T) {
	assert.Equal(t, 90, maxProduct(&TreeNode{
		Val:  1,
		Left: nil,
		Right: &TreeNode{
			Val: 2,
			Left: &TreeNode{
				Val:   3,
				Left:  nil,
				Right: nil,
			},
			Right: &TreeNode{
				Val: 4,
				Left: &TreeNode{
					Val:   5,
					Left:  nil,
					Right: nil,
				},
				Right: &TreeNode{
					Val:   6,
					Left:  nil,
					Right: nil,
				},
			},
		},
	}))
	assert.Equal(t, 1, maxProduct(&TreeNode{
		Val:  1,
		Left: &TreeNode{Val: 1},
	}))
	assert.Equal(t, 1025, maxProduct(&TreeNode{
		Val: 2,
		Left: &TreeNode{
			Val: 3,
			Left: &TreeNode{
				Val:   10,
				Left:  &TreeNode{Val: 5},
				Right: &TreeNode{Val: 4},
			},
			Right: &TreeNode{
				Val:   7,
				Left:  &TreeNode{Val: 11},
				Right: &TreeNode{Val: 1},
			},
		},
		Right: &TreeNode{Val: 9, Left: &TreeNode{Val: 8}, Right: &TreeNode{Val: 6}},
	}))
}
