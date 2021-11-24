package main

import (
	"sort"
	"strconv"
)

func minNumber(nums []int) string {
	strs := make([]string, len(nums))
	for i := 0; i < len(nums); i++ {
		strs[i] = strconv.Itoa(nums[i])
	}
	sort.Slice(strs, func(i, j int) bool {
		return strs[i]+strs[j] < strs[j]+strs[i]
	})
	var s string
	for _, n := range strs {
		s += n
	}
	return s
}
