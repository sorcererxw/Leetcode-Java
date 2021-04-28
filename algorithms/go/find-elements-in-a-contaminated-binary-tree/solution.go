package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func main() {
	//obj := Constructor(root)
	//param_1 := obj.Find(target)
}

/*******************************************/

type FindElements struct {
	dist map[int32]*struct{}
}

func Constructor(root *TreeNode) FindElements {
	dist := make(map[int32]*struct{})
	q := make([]*TreeNode, 0)
	if root == nil {
		return FindElements{dist: dist}
	}
	root.Val = 0
	q = append(q, root)
	for len(q) > 0 {
		node := q[0]
		q = q[1:]
		dist[int32(node.Val)] = nil
		if node.Left != nil {
			node.Left.Val = node.Val*2 + 1
			q = append(q, node.Left)
		}
		if node.Right != nil {
			node.Right.Val = node.Val*2 + 2
			q = append(q, node.Right)
		}
	}
	return FindElements{dist: dist}
}

func (c *FindElements) Find(target int) bool {
	_, ok := c.dist[int32(target)]
	return ok
}
