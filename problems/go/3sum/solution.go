package main

import (
	"sort"
)

func threeSum(nums []int) [][]int {
	ans := make([][]int, 0)
	sort.Ints(nums)
	for k := 0; k < len(nums); k++ {
		if k > 0 && nums[k] == nums[k-1] {
			continue
		}
		i, j := k+1, len(nums)-1
		for i < j {
			if nums[k]+nums[i]+nums[j] == 0 {
				ans = append(ans, []int{nums[k], nums[i], nums[j]})
				for i < j && nums[i] == nums[i+1] {
					i++
				}
				for i < j && nums[j] == nums[j-1] {
					j--
				}
				i++
				j--
			} else if nums[k]+nums[i]+nums[j] > 0 {
				j--
			} else if nums[k]+nums[i]+nums[j] < 0 {
				i++
			}
		}
	}
	return ans
}
