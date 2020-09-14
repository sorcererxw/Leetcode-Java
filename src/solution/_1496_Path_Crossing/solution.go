package _1496_Path_Crossing

func isPathCrossing(path string) bool {
	set := make(map[[2]int]struct{}, len(path)+1)
	x := 0
	y := 0
	set[[2]int{x, y}] = struct{}{}
	for _, dir := range path {
		switch dir {
		case 'N':
			y++
		case 'S':
			y--
		case 'E':
			x++
		case 'W':
			x--
		}
		if _, ok := set[[2]int{x, y}]; ok {
			return true
		}
		set[[2]int{x, y}] = struct{}{}
	}
	return false
}
