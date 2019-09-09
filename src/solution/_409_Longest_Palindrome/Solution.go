package _409_Longest_Palindrome

func longestPalindrome(s string) int {
	cm := make([]int, 256)
	sum := 0
	for i := 0; i < len(s); i++ {
		var idx = s[i] - 'a'
		cm[idx]++
		if cm[idx]%2 == 0 {
			sum += 2
		}
	}
	if sum < len(s) {
		sum += 1
	}
	return sum
}
