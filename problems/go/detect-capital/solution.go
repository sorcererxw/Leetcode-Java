package main

func detectCapitalUse(word string) bool {
	lastCap := false
	for i := 0; i < len(word); i++ {
		cap := word[i] >= 'A' && word[i] <= 'Z'
		if lastCap == cap {
		} else if i == 0 {
		} else if i == 1 && lastCap {
		} else {
			return false
		}
		lastCap = cap
	}
	return true
}
