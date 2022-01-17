package main

type TreeNode struct {
	Left  *TreeNode
	Right *TreeNode
	Val   int
}

func longestUnivaluePath(root *TreeNode) int {
	var ans int
	dfs(root, &ans)
	return ans
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func dfs(root *TreeNode, ans *int) int {
	if root == nil {
		return 0
	}
	l, r := dfs(root.Left, ans), dfs(root.Right, ans)
	vl, vr := 0, 0
	if root.Left != nil && root.Left.Val == root.Val {
		vl = l + 1
	}
	if root.Right != nil && root.Right.Val == root.Val {
		vr = r + 1
	}
	*ans = max(*ans, vl+vr)
	return max(vl, vr)
}
