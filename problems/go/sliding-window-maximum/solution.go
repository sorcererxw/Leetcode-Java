package main

func maxSlidingWindow(nums []int, k int) (ans []int) {
	deque := []int{}

	push := func(i int) {
		for len(deque) > 0 && nums[i] >= nums[deque[len(deque)-1]] {
			deque = deque[:len(deque)-1]
		}
		deque = append(deque, i)
	}

	for i := 0; i < len(nums); i++ {
		push(i)
		if i < k-1 {
			continue
		}
		for deque[0] <= i-k {
			deque = deque[1:]
		}
		ans = append(ans, nums[deque[0]])
	}
	return
}
