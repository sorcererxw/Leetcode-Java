package main

import "sort"

func minSetSize(arr []int) int {
	m := make(map[int]int)
	for _, it := range arr {
		m[it] += 1
	}
	s := make([]int, 0, len(m))
	for _, v := range m {
		s = append(s, v)
	}
	sort.Slice(s, func(i, j int) bool { return s[i] > s[j] })
	var cnt, sum int
	for ; cnt < len(s) && sum*2 < len(arr); cnt++ {
		sum += s[cnt]
	}
	return cnt
}
