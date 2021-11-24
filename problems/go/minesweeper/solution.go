package main

func updateBoard(board [][]byte, click []int) [][]byte {
	if len(board) == 0 {
		return board
	}
	w, h := len(board), len(board[0])
	directions := [8][2]int{{1, -1}, {1, 0}, {1, 1}, {0, 1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}}
	q := make([][2]int, 0, 1)
	q = append(q, [2]int{click[0], click[1]})
	for len(q) > 0 {
		c := q[0]
		q = q[1:]
		x, y := c[0], c[1]
		switch board[x][y] {
		case 'M':
			board[x][y] = 'X'
			break
		case 'E':
			var bomb uint8
			_q := make([][2]int, 0, 8)
			for _, dir := range directions {
				_x, _y := x+dir[0], y+dir[1]
				if _x < 0 || _x >= w {
					continue
				}
				if _y < 0 || _y >= h {
					continue
				}
				switch board[_x][_y] {
				case 'E':
					_q = append(_q, [2]int{_x, _y})
				case 'M':
					bomb++
				}
			}
			if bomb > 0 {
				board[x][y] = '0' + bomb
			} else {
				board[x][y] = 'B'
				q = append(q, _q...)
			}
		}
	}
	return board
}
