package main

const N = 1000000007

func findPaths(m int, n int, maxMove int, startRow int, startColumn int) int {
	mem := make([][][]int, m)
	for i := 0; i < m; i++ {
		mem[i] = make([][]int, n)
		for j := 0; j < n; j++ {
			mem[i][j] = make([]int, maxMove+1)
			for k := 0; k <= maxMove; k++ {
				mem[i][j][k] = -1
			}
		}
	}
	return dfs(m, n, maxMove, startRow, startColumn, mem)
}

func dfs(m int, n int, maxMove int, i int, j int, mem [][][]int) int {
	if i < 0 || j < 0 || i >= m || j >= n {
		return 1
	}
	if maxMove <= 0 {
		return 0
	}
	if mem[i][j][maxMove] >= 0 {
		return mem[i][j][maxMove]
	}
	mem[i][j][maxMove] = ((dfs(m, n, maxMove-1, i+1, j, mem)+dfs(m, n, maxMove-1, i-1, j, mem))%N +
		(dfs(m, n, maxMove-1, i, j+1, mem)+dfs(m, n, maxMove-1, i, j-1, mem))%N) % N
	return mem[i][j][maxMove]
}
