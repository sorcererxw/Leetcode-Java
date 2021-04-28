package _88_Merge_Sorted_Array

func merge(nums1 []int, m int, nums2 []int, n int) {
	i := m - 1
	j := n - 1
	k := m + n - 1
	for i >= 0 && j >= 0 {
		if nums1[i] >= nums2[j] {
			nums1[k] = nums1[i]
			i--
		} else {
			nums1[k] = nums2[j]
			j--
		}
		k--
	}
	// 因为本来就是往 nums1 里面挪，故不需要考虑 nums1 内是否还有剩余
	for j >= 0 {
		nums1[k] = nums2[j]
		j--
		k--
	}
}
