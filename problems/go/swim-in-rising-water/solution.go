package main

func swimInWater(grid [][]int) int {
	if len(grid) == 0 || len(grid[0]) == 0 {
		return 0
	}
	h, w := len(grid), len(grid[0])

	type Node struct {
		i, j, cur int
	}
	queue := make([]Node, 0, len(grid))
	queue = append(queue, Node{})

	cost := make([][]int, h)
	for i := 0; i < h; i++ {
		cost[i] = make([]int, w)
		for j := 0; j < w; j++ {
			cost[i][j] = -1
		}
	}

	for len(queue) > 0 {
		top := queue[0]
		queue = queue[1:]

		i, j := top.i, top.j
		v := top.cur
		if v < grid[i][j] {
			v = grid[i][j]
		}
		if cost[i][j] >= 0 {
			if cost[i][j] <= v {
				continue
			}
		}
		cost[i][j] = v
		if i+1 < h {
			queue = append(queue, Node{
				i:   i + 1,
				j:   j,
				cur: v,
			})
		}
		if j+1 < w {
			queue = append(queue, Node{
				i:   i,
				j:   j + 1,
				cur: v,
			})
		}
		if i-1 >= 0 {
			queue = append(queue, Node{
				i:   i - 1,
				j:   j,
				cur: v,
			})
		}
		if j-1 >= 0 {
			queue = append(queue, Node{
				i:   i,
				j:   j - 1,
				cur: v,
			})
		}
	}
	return cost[h-1][w-1]
}
