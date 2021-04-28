package model

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func (c *TreeNode) PreOrderTraversal() []int {
	var res []int
	var stack []*TreeNode
	stack = append(stack, c)
	for {
		if len(stack) == 0 {
			break
		}
		top := stack[len(stack)-1]
		stack = stack[:len(stack)-1]
		if top == nil {
			res = append(res, 0)
			continue
		}
		stack = append(stack, top.Right)
		stack = append(stack, top.Left)
		res = append(res, top.Val)
	}
	return res
}
