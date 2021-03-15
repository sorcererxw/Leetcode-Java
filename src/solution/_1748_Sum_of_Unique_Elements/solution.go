package main

import "sort"

func sumOfUnique(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	if len(nums) == 1 {
		return nums[0]
	}
	sort.Sort(sort.IntSlice(nums))
	var sum int
	for i := 0; i < len(nums); i++ {
		if i == 0 {
			if nums[i] != nums[i+1] {
				sum += nums[i]
			}
		} else if i == len(nums)-1 {
			if nums[i] != nums[i-1] {
				sum += nums[i]
			}
		} else if nums[i] != nums[i+1] && nums[i] != nums[i-1] {
			sum += nums[i]
		}
	}
	return sum
}
