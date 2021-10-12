package main

import (
	"sort"
)

func canPartitionKSubsets(nums []int, k int) bool {
	var sum int
	for _, s := range nums {
		sum += s
	}
	if sum%k != 0 {
		return false
	}
	sort.Slice(nums, func(i, j int) bool {
		return nums[i] < nums[j]
	})
	avg := sum / k
	var (
		i = 0
		j = len(nums) - 1
	)
	for i<=j{
		if nums[j]>avg {
			return false
		}
		if nums[j]==avg {
			j--
			continue
		}
		
	}
}
