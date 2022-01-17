package main

func lengthOfLIS(nums []int) int {
	dp := make([]int, 0, len(nums))
	for i := range nums {
		if i == 0 {
			dp = append(dp, nums[i])
			continue
		}
		if nums[i] > dp[len(dp)-1] {
			dp = append(dp, nums[i])
		} else {
			l := 0
			r := len(dp) - 1
			p := 0
			for l <= r {
				mid := l + (r-l)/2
				if dp[mid] >= nums[i] {
					p = mid
					r = mid - 1
				} else {
					l = mid + 1
				}
			}
			dp[p] = nums[i]
		}
	}
	return len(dp)
}
