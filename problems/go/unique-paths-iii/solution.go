package main

/*
You are given an m x n integer array grid where grid[i][j] could be:

1 representing the starting square. There is exactly one starting square.
2 representing the ending square. There is exactly one ending square.
0 representing empty squares we can walk over.
-1 representing obstacles that we cannot walk over.
Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
*/

func uniquePathsIII(grid [][]int) int {
	if len(grid) == 0 {
		return 0
	}
	m, n := len(grid), len(grid[0])
	var sum int
	var st [2]int
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if grid[i][j] != -1 {
				sum += 1
			}
			if grid[i][j] == 1 {
				st = [2]int{i, j}
			}
		}
	}
	return dfs(grid, st[0], st[1], sum-1, map[[2]int]struct{}{})
}

func dfs(grid [][]int, i, j int, cnt int, vis map[[2]int]struct{}) int {
	if _, ok := vis[[2]int{i, j}]; ok {
		return 0
	}
	if i >= len(grid) || i < 0 || j >= len(grid[i]) || j < 0 {
		return 0
	}
	if grid[i][j] == -1 {
		return 0
	}
	if grid[i][j] == 2 {
		if cnt == 0 {
			return 1
		} else {
			return 0
		}
	}
	vis[[2]int{i, j}] = struct{}{}
	defer func() {
		delete(vis, [2]int{i, j})
	}()
	return dfs(grid, i+1, j, cnt-1, vis) +
		dfs(grid, i-1, j, cnt-1, vis) +
		dfs(grid, i, j+1, cnt-1, vis) +
		dfs(grid, i, j-1, cnt-1, vis)
}
