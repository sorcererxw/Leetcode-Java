package _1232_Check_If_It_Is_a_Straight_Line

func checkStraightLine(coordinates [][]int) bool {
	if len(coordinates) <= 2 {
		return true
	}
	for i := 2; i < len(coordinates); i++ {
		x1, y1 := coordinates[i-2][0], coordinates[i-2][1]
		x2, y2 := coordinates[i-1][0], coordinates[i-1][1]
		x3, y3 := coordinates[i][0], coordinates[i][1]

		if (x1-x2)*(y2-y3) != (x2-x3)*(y1-y2) {
			return false
		}
	}

	return true
}
