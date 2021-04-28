package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func increasingBST(root *TreeNode) *TreeNode {
	head, last = nil, nil
	visit(root)
	return head
}

var head *TreeNode
var last *TreeNode

func visit(root *TreeNode) {
	if root == nil {
		return
	}
	visit(root.Left)
	if head == nil {
		head = root
	}
	if last != nil {
		last.Right = root
	}
	root.Left = nil
	last = root
	visit(root.Right)
}
