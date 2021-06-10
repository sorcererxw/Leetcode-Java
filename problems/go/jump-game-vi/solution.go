package main

func maxResult(nums []int, k int) int {
	deque := make([][2]int, 0, k+1)

	var ret int
	for i := 0; i < len(nums); i++ {
		v := nums[i]
		if len(deque) > 0 {
			v += deque[0][1]
		}
		if i == len(nums)-1 {
			ret = v
			break
		}
		for len(deque) > 0 && deque[0][0]+k <= i {
			deque = deque[1:]
		}
		for len(deque) > 0 && deque[len(deque)-1][1] <= v {
			deque = deque[:len(deque)-1]
		}
		deque = append(deque, [2]int{i, v})
	}
	return ret
}
