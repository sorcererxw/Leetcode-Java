package main

import "fmt"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

/*
func pathSum(root *TreeNode, targetSum int) int {
	if root == nil {
		return 0
	}
	return dfs(root, targetSum) + pathSum(root.Right, targetSum) + pathSum(root.Left, targetSum)
}

func dfs(root *TreeNode, target int) (count int) {
	if root == nil {
		return
	}
	if root.Val == target {
		count += 1
	}
	count += dfs(root.Left, target-root.Val) + dfs(root.Right, target-root.Val)
	return
}
*/

func pathSum(root *TreeNode, targetSum int) int {
	if root == nil {
		return 0
	}
	m := make(map[int]int, 1000)
	return dfs(root, targetSum, m)
}

func dfs(root *TreeNode, target int, sum map[int]int) (count int) {
	if root == nil {
		return
	}
	if root.Val == target {
		count += 1
	}
	sum[]
	count += dfs(root.Left, target-root.Val) + dfs(root.Right, target-root.Val)
	return
}

func main() {
	fmt.Println(pathSum(&TreeNode{
		Val: 10,
		Left: &TreeNode{
			Val: 5,
			Left: &TreeNode{
				Val:   3,
				Left:  &TreeNode{Val: 3},
				Right: &TreeNode{Val: -2},
			},
			Right: &TreeNode{
				Val:   2,
				Right: &TreeNode{Val: 1},
			},
		},
		Right: &TreeNode{
			Val:   -3,
			Right: &TreeNode{Val: 11},
		},
	}, 8))
}

/**
ch := make(chan int, 2)
var wg sync.WaitGroup
wg.Add(2)
go func() {
	defer wg.Done()
	ch <- dfs(root.Left, target, newPathSum)
}()
go func() {
	defer wg.Done()
	ch <- dfs(root.Right, target, newPathSum)
}()
wg.Wait()
close(ch)
for v:=range ch {
	count+=v
}
*/
