package _830_Positions_of_Large_Groups

func largeGroupPositions(S string) [][]int {
	var result [][]int
	if len(S) == 0 {
		return result
	}
	lastChar := S[0]
	lastIndex := 0

	for i := 1; i <= len(S); i++ {
		if i == len(S) || S[i] != lastChar {
			if i-lastIndex >= 3 {
				result = append(result, []int{lastIndex, i - 1})
			}
			if i < len(S) {
				lastIndex = i
				lastChar = S[i]
			}
		}
	}
	return result
}
