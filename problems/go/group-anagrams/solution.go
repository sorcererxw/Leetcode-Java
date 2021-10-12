package main

func groupAnagrams(strs []string) [][]string {
	m := make(map[[26]int][]string)
	for i := 0; i < len(strs); i++ {
		var h [26]int
		for j := 0; j < len(strs[i]); j++ {
			h[strs[i][j]-'a']++
		}
		m[h] = append(m[h], strs[i])
	}
	ans := make([][]string, 0)
	for k := range m {
		ans = append(ans, m[k])
	}
	return ans
}
