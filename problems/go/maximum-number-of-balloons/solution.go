package main

func min(items ...int) int {
	if len(items) == 0 {
		return 0
	}
	m := items[0]
	for i := 1; i < len(items); i++ {
		if items[i] < m {
			m = items[i]
		}
	}
	return m
}

func maxNumberOfBalloons(text string) int {
	var cnt [26]int
	for i := 0; i < len(text); i++ {
		cnt[text[i]-'a'] += 1
	}
	return min(cnt['b'-'a'], cnt['a'-'a'], cnt['l'-'a']/2, cnt['o'-'a']/2, cnt['n'-'a'])
}
