package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func buildTree(preorder []int, inorder []int) *TreeNode {
	return buildTreeRecursively(preorder, 0, len(preorder)-1, inorder, 0, len(inorder)-1)
}

func buildTreeRecursively(preorder []int, l1, r1 int, inorder []int, l2, r2 int) *TreeNode {
	if l1 > r1 || l2 > r2 || l1 < 0 || l2 < 0 || r1 >= len(preorder) || r2 >= len(inorder) {
		return nil
	}
	v := preorder[l1]
	i := l2
	for ; i <= r2; i++ {
		if inorder[i] == v {
			break
		}
	}
	llen := i - l2

	node := &TreeNode{Val: v}
	node.Left = buildTreeRecursively(preorder, l1+1, l1+llen, inorder, l2, i-1)
	node.Right = buildTreeRecursively(preorder, l1+llen+1, r1, inorder, i+1, r2)
	return node
}
