package main

func maxAreaOfIsland(grid [][]int) int {
	var max = 0

	h := len(grid)
	if h == 0 {
		return 0
	}
	w := len(grid[0])

	for i := 0; i < h; i++ {
		for j := 0; j < w; j++ {
			if grid[i][j] == 0 {
				continue
			}
			q := make([][2]int, 0, 1)
			q = append(q, [2]int{i, j})
			var size int
			for len(q) > 0 {
				top := q[0]
				q = q[1:]
				x, y := top[0], top[1]
				if grid[x][y] == 0 {
					continue
				}
				if x+1 < h && grid[x+1][y] > 0 {
					q = append(q, [2]int{x + 1, y})
				}
				if y+1 < w && grid[x][y+1] > 0 {
					q = append(q, [2]int{x, y + 1})
				}
				if x-1 >= 0 && grid[x-1][y] > 0 {
					q = append(q, [2]int{x - 1, y})
				}
				if y-1 >= 0 && grid[x][y-1] > 0 {
					q = append(q, [2]int{x, y - 1})
				}
				grid[x][y] = 0
				size += 1
			}
			if size > max {
				max = size
			}
		}
	}

	return max
}
