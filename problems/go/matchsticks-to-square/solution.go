package main

func makesquare(matchsticks []int) bool {
	if len(matchsticks) < 4 {
		return false
	}
	var sum int
	for i := 0; i < len(matchsticks); i++ {
		sum += matchsticks[i]
	}
	if sum%4 != 0 || sum == 0 {
		return false
	}
	side := sum / 4
	m := make(map[int]int, len(matchsticks))
	for i := 0; i < len(matchsticks); i++ {
		sum += matchsticks[i]
	}
}
