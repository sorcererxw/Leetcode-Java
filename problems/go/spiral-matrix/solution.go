package main

type Direction struct {
	X    int
	Y    int
	Next *Direction
}

var direction = &Direction{
	Y: 1,
}

func init() {
	direction.Next = &Direction{
		X: 1,
		Next: &Direction{
			Y: -1,
			Next: &Direction{
				X:    -1,
				Next: direction,
			},
		},
	}
}

func spiralOrder(matrix [][]int) []int {
	if len(matrix) == 0 {
		return []int{}
	}
	h, w := len(matrix), len(matrix[0])
	n := h * w
	ans := make([]int, n)
	var x, y = 0, 0
	set := make(map[int]struct{})
	d := direction
	for i := 0; i < n; i++ {
		ans[i] = matrix[x][y]
		set[x*w+y] = struct{}{}
		{
			_x, _y := x+d.X, y+d.Y
			if _x >= h || _x < 0 || _y >= w || _y < 0 {
				d = d.Next
			} else if _, ok := set[_x*w+_y]; ok {
				d = d.Next
			}
		}
		x += d.X
		y += d.Y
	}
	return ans
}
