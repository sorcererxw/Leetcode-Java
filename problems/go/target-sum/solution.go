package main

func findTargetSumWays(nums []int, target int) int {
	return dfs(nums, target, 0, map[[2]int]int{})
}

func dfs(nums []int, target int, i int, memo map[[2]int]int) int {
	if i == len(nums) {
		if target == 0 {
			return 1
		}
		return 0
	}
	if v, ok := memo[[2]int{i, target}]; ok {
		return v
	}
	ans := dfs(nums, target+nums[i], i+1, memo) + dfs(nums, target-nums[i], i+1, memo)
	memo[[2]int{i, target}] = ans
	return ans
}
