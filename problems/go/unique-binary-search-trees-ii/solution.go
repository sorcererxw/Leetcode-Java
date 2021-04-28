package _95_unique_binary_search_trees_ii

import . "github.com/sorcererxw/leetcode/src/models"

func generateTrees(n int) []*TreeNode {
	return buildTrees(1, n)
}

func buildTrees(st, ed int) []*TreeNode {
	if st > ed {
		return nil
	}
	var res []*TreeNode
	for i := st; i <= ed; i++ {
		leftTrees := buildTrees(st, i-1)
		rightTrees := buildTrees(i+1, ed)
		for _, lt := range leftTrees {
			for _, rt := range rightTrees {
				res = append(res, &TreeNode{
					Val:   i,
					Left:  lt,
					Right: rt,
				})
			}
		}
	}
	return res
}
