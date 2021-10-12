package main

func longestOnes(nums []int, k int) int {
	var l, lsum, rsum, max int
	for r := 0; r < len(nums); r++ {
		rsum += 1 - nums[r]
		for lsum < rsum-k {
			lsum += 1 - nums[l]
			l++
		}
		if r-l+1 > max {
			max = r - l + 1
		}
	}
	return max
}
