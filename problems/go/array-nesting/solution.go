package array_nesting

// 必定是无环图

func arrayNesting(nums []int) int {
	vis := make([]bool, len(nums))
	max := 0
	for i := 0; i < len(nums); i++ {
		if vis[i] {
			continue
		}
		start := nums[i]
		cnt := 0
		for true {
			start = nums[start]
			cnt += 1
			vis[start] = true
			if start == nums[i] {
				break
			}
		}
		if cnt > max {
			max = cnt
		}
	}
	return max
}

// 5 4 0 3 1 6 2
