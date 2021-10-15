package main

var ans [][]string

func solveNQueens(n int) [][]string {
	ans = make([][]string, 0)
	q := make([]int, n)
	for i := 0; i < n; i++ {
		q[i] = -1
	}
	dfs(q, n, 0, map[int]bool{}, map[int]bool{}, map[int]bool{})
	return ans
}

func dfs(q []int, n int, row int, col, dig1, dig2 map[int]bool) {
	if n == row {
		ans = append(ans, board(q, n))
		return
	}
	for i := 0; i < n; i++ {
		if col[i] {
			continue
		}
		if dig1[i+row] {
			continue
		}
		if dig2[i-row] {
			continue
		}
		q[row] = i
		col[i] = true
		dig1[i+row] = true
		dig2[i-row] = true

		dfs(q, n, row+1, col, dig1, dig2)

		q[row] = -1
		delete(col, i)
		delete(dig1, i+row)
		delete(dig2, i-row)
	}
}

func board(q []int, n int) []string {
	b := make([]string, 0, len(q))
	for _, pos := range q {
		row := make([]byte, n)
		for i := 0; i < n; i++ {
			switch i {
			case pos:
				row[i] = 'Q'
			default:
				row[i] = '.'
			}
		}
		b = append(b, string(row))
	}
	return b
}
