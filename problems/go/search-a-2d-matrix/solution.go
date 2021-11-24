package main

import (
	"sort"
)

func searchMatrix(matrix [][]int, target int) bool {
	k := sort.Search(len(matrix), func(i int) bool { return matrix[i][0] > target }) - 1
	if k < 0 {
		return false
	}
	l := sort.Search(len(matrix[k]), func(i int) bool { return matrix[k][i] >= target })
	if l >= len(matrix[k]) {
		return false
	}
	return matrix[k][l] == target
}
