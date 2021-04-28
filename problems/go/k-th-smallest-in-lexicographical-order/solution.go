package main

import "fmt"

func main() {
	fmt.Println(findKthNumber(13, 2))
}

func dfs(current int, k *int, max int) int {
	if current > max {
		return 0
	}
	if current > 0 {
		*k--
	}
	if *k == 0 {
		return current
	}
	for i := 0; i <= 9; i++ {
		if current==0 && i==0 {
			continue
		}
		if v := dfs(current*10+i, k, max); v != 0 {
			return v
		}
	}
	return 0
}

func findKthNumber(n int, k int) int {
	return dfs(0, &k, n)
}
