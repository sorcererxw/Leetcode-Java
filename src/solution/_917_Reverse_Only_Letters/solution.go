package _917_Reverse_Only_Letters

import (
	"unicode"
)

func reverseOnlyLetters(S string) string {
	s := []rune(S)
	i := 0
	j := len(s) - 1
	for i < j {
		if !unicode.IsLetter(s[i]) {
			i++
			continue
		}
		if !unicode.IsLetter(s[j]) {
			j--
			continue
		}
		s[i], s[j] = s[j], s[i]
		i++
		j--
	}
	return string(s)
}
