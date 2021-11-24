package main

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func trap(height []int) int {
	l, r := 0, len(height)-1
	var lmax, rmax int
	var sum int
	for l < r {
		lmax = max(lmax, height[l])
		rmax = max(rmax, height[r])
		if lmax < rmax {
			sum += lmax - height[l]
			l++
		} else {
			sum += rmax - height[r]
			r--
		}
	}
	return sum
}
