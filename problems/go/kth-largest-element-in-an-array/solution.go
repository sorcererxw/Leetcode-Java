package main

import "math/rand"

func findKthLargest(nums []int, k int) int {
	rand.Shuffle(len(nums), func(i, j int) { nums[i], nums[j] = nums[j], nums[i] })
	k = len(nums) - k
	low, high := 0, len(nums)-1
	for low < high {
		mid := partition(nums, low, high)
		if mid < k {
			low = mid + 1
		} else if mid > k {
			high = mid - 1
		} else {
			break
		}
	}
	return nums[k]
}

func partition(nums []int, low, high int) int {
	i, j := low+1, high
	v := nums[low]
	for {
		for nums[i] <= v && i < high {
			i++
		}
		for nums[j] > v && j > low {
			j--
		}
		if i >= j {
			break
		}
		nums[i], nums[j] = nums[j], nums[i]
	}
	nums[low], nums[j] = nums[j], nums[low]
	return j
}
