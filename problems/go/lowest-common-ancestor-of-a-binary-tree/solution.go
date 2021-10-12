package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	var ret *TreeNode
	visit(root, p, q, &ret)
	return ret
}

func visit(root, p, q *TreeNode, ret **TreeNode) bool {
	if root == nil {
		return false
	}
	var sum int
	if visit(root.Left, p, q, ret) {
		sum += 1
	}
	if visit(root.Right, p, q, ret) {
		sum += 1
	}
	if root == p || root == q {
		sum += 1
	}
	if sum >= 2 {
		*ret = root
	}
	return sum > 0
}
