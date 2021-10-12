package main

func intersect(nums1 []int, nums2 []int) []int {
	var vis [1001]int16
	ans := make([]int, 0, 10)
	for i := 0; i < len(nums1); i++ {
		vis[nums1[i]] += 1
	}
	for i := 0; i < len(nums2); i++ {
		if vis[nums2[i]] > 0 {
			vis[nums2[i]] -= 1
			ans = append(ans, nums2[i])
		}
	}
	return ans
}
