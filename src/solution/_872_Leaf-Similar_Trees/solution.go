package _872_Leaf_Similar_Trees

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func travel(tree *TreeNode, level int, out chan<- int) {
	if tree != nil {
		travel(tree.Left, level+1, out)
		if tree.Left == nil && tree.Right == nil {
			out <- tree.Val
		}
		travel(tree.Right, level+1, out)
	}
	if level == 1 {
		close(out)
	}
}

func leafSimilar(root1 *TreeNode, root2 *TreeNode) bool {
	lch := make(chan int)
	rch := make(chan int)

	go travel(root1, 1, lch)
	go travel(root2, 1, rch)

	for {
		l, lok := <-lch
		r, rok := <-rch
		if lok != rok {
			return false
		}
		if !lok || !rok {
			break
		}
		if l != r {
			return false
		}
	}
	return true
}
