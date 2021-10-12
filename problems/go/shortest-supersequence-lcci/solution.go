package main

func shortestSeq(big []int, small []int) []int {
	var l, r int

	m := make(map[int]int, len(small))
	for i := range small {
		m[small[i]] = 0
	}

	for r < len(big) {
		small = append(small, big[r])
		
	}
}
