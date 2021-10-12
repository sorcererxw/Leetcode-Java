package main

func sortArrayByParityII(nums []int) []int {
	j := 1
	for i := 0; i < len(nums); i += 2 {
		if nums[i]%2 == 0 {
			continue
		}
		for nums[j]%2 == 1 {
			j += 2
		}
		nums[i], nums[j] = nums[j], nums[i]
	}
	return nums
}
