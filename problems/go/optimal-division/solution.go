package main

import (
	"strconv"
)

func optimalDivision(nums []int) string {
	if len(nums) == 0 {
		return ""
	}
	if len(nums) == 1 {
		return strconv.Itoa(nums[0])
	}
	if len(nums) == 2 {
		return strconv.Itoa(nums[0]) + "/" + strconv.Itoa(nums[1])
	}
	ret := strconv.Itoa(nums[0]) + "/"
	ret += "("
	for i := 1; i < len(nums); i++ {
		if i > 1 {
			ret += "/"
		}
		ret+=strconv.Itoa(nums[i])
	}
	ret += ")"
	return ret
}
