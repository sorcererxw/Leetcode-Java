package main

/*
We are given an array nums of positive integers, and two positive integers left and right (left <= right).

Return the number of (contiguous, non-empty) subarrays such that the value of the maximum array element in that subarray is at least left and at most right.

Example:
Input:
nums = [2, 1, 4, 3]
left = 2
right = 3
Output: 3

Explanation: There are three subarrays that meet the requirements: [2], [2, 1], [3].
Note:

left, right, and nums[i] will be an integer in the range [0, 109].
The length of nums will be in the range of [1, 50000].
*/

func numSubarrayBoundedMax(nums []int, left int, right int) int {
	return count(nums, right) - count(nums, left-1)
}

func count(nums []int, max int) int {
	var ret, step int
	for i := 0; i < len(nums); i++ {
		if nums[i] <= max {
			step += 1
		} else {
			step = 0
		}
		ret += step
	}
	return ret
}
