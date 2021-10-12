package maximum_product_of_splitted_binary_tree

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func countSum(root *TreeNode) int {
	if root == nil {
		return 0
	}
	return countSum(root.Left) + countSum(root.Right) + root.Val
}

var sum int

var v int

func abs(a int) int {
	if a > 0 {
		return a
	}
	return -a
}

func dfs(root *TreeNode) int {
	if root == nil {
		return 0
	}
	ret := dfs(root.Left) + dfs(root.Right) + root.Val
	if abs(ret*2-sum) < abs(v*2-sum) {
		v = ret
	}
	return ret
}

func maxProduct(root *TreeNode) int {
	sum = countSum(root)
	dfs(root)
	return ((sum - v) * v) % 1000000007
}
