package main

import "sort"

func maximumUnits(boxTypes [][]int, truckSize int) int {
	sort.Slice(boxTypes, func(i, j int) bool {
		return boxTypes[i][1] > boxTypes[j][1]
	})
	var sum int
	for i := 0; i < len(boxTypes) && truckSize > 0; i++ {
		cnt := boxTypes[i][0]
		if cnt > truckSize {
			cnt = truckSize
		}
		truckSize = truckSize - cnt
		sum = sum + boxTypes[i][1]*cnt
	}
	return sum
}
