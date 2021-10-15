package main

// 滑动窗口
func shortestSeq(big []int, small []int) []int {
	var l, r int
	var cnt int
	ans := []int{}

	m := make(map[int]int, len(small))
	for i := range small {
		m[small[i]] = 0
	}

	for {
		if cnt < len(small) && r < len(big) {
			if _, ok := m[big[r]]; ok {
				m[big[r]] += 1
				if m[big[r]] == 1 {
					cnt += 1
				}
			}
			r++
		} else if cnt == len(small) && l < r {
			if len(ans) == 0 || ans[1]-ans[0] > r-1-l {
				ans = []int{l, r - 1}
			}
			if _, ok := m[big[l]]; ok {
				m[big[l]] -= 1
				if m[big[l]] == 0 {
					cnt -= 1
				}
			}
			l++
		} else {
			break
		}
	}
	return ans
}
