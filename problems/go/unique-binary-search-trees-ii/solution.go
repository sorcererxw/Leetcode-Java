package _95_unique_binary_search_trees_ii

import (
	. "github.com/sorcererxw/leetcode/_common/model"
)

func generateTrees(n int) []*TreeNode {
	return buildTrees(1, n)
}

func buildTrees(st, ed int) []*TreeNode {
	var res []*TreeNode
	for i := st; i <= ed; i++ {
		leftTrees := buildTrees(st, i-1)
		rightTrees := buildTrees(i+1, ed)
		if len(leftTrees) > 0 && len(rightTrees) > 0 {
			for _, lt := range leftTrees {
				for _, rt := range rightTrees {
					res = append(res, &TreeNode{
						Val:   i,
						Left:  lt,
						Right: rt,
					})
				}
			}
		} else if len(leftTrees) > 0 {
			for _, lt := range leftTrees {
				res = append(res, &TreeNode{
					Val:  i,
					Left: lt,
				})
			}
		} else if len(rightTrees) > 0 {
			for _, rt := range rightTrees {
				res = append(res, &TreeNode{
					Val:   i,
					Right: rt,
				})
			}
		} else {
			res = append(res, &TreeNode{
				Val: i,
			})
		}
	}
	return res
}
