package main

func subsets(nums []int) [][]int {
	ans := make([][]int, 0, 1<<len(nums))
	ans = append(ans, []int{})
	for i := 0; i < len(nums); i++ {
		l := len(ans)
		for j := 0; j < l; j++ {
			t := make([]int, len(ans[j]), len(ans[j])+1)
			copy(t, ans[j])
			t = append(t, nums[i])
			ans = append(ans, t)
		}
	}
	return ans
}
