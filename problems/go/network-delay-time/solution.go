package main

const inf = 1000000 // 6000*100

func networkDelayTime(times [][]int, n int, k int) int {
	g := make(map[[2]int]int, len(times))
	for _, t := range times {
		g[[2]int{t[0], t[1]}] = t[2]
	}
	vis := make([]bool, n+1)
	dis := make([]int, n+1)
	for i := 1; i <= n; i++ {
		if i == k {
			continue
		}
		dis[i] = inf
	}
	for i := 1; i <= n; i++ {
		var x int
		// find the nearest new node
		for y := 1; y <= n; y++ {
			if vis[y] {
				continue
			}
			if x == 0 || dis[y] < dis[x] {
				x = y
			}
		}
		if dis[x] == inf {
			return -1
		}
		vis[x] = true
		for y := 1; y <= n; y++ {
			d, ok := g[[2]int{x, y}]
			if !ok {
				continue
			}
			if dis[y] > dis[x]+d {
				dis[y] = dis[x] + d
			}
		}
	}
	var ans int
	for _, d := range dis {
		if d > ans {
			ans = d
		}
	}
	return ans
}
