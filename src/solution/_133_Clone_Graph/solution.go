package _133_Clone_Graph

type Node struct {
	Val       int
	Neighbors []*Node
}

func cloneGraph(node *Node) *Node {
	if node == nil {
		return nil
	}
	newNode := Node{Val: node.Val}
	
}
