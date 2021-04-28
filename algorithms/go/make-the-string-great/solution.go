package _1544_Make_The_String_Great

import (
	"unicode"
)

func makeGood(s string) string {
	stack := make([]rune, 0, len(s))
	for _, c := range s {
		if len(stack) == 0 {
			stack = append(stack, c)
			continue
		}
		top := stack[len(stack)-1]
		if top != c && unicode.ToLower(top) == unicode.ToLower(c) {
			stack = stack[:len(stack)-1]
		} else {
			stack = append(stack, c)
		}
	}
	return string(stack)
}
