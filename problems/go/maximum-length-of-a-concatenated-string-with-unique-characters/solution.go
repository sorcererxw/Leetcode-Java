package main

func maxLength(arr []string) int {
	return dfs(arr, 0, map[byte]struct{}{})
}

func dfs(arr []string, idx int, vis map[byte]struct{}) int {
	if idx >= len(arr) {
		return len(vis)
	}
	ans := dfs(arr, idx+1, vis)
	s := arr[idx]
	for i := range s {
		_, ok := vis[s[i]]
		if ok {
			for j := i - 1; j >= 0; j-- {
				delete(vis, s[j])
			}
			return ans
		}
		vis[s[i]] = struct{}{}
	}
	if v := dfs(arr, idx+1, vis); v > ans {
		ans = v
	}
	for i := range s {
		delete(vis, s[i])
	}
	return ans
}
