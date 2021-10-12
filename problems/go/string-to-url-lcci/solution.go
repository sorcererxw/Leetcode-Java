package main

import "strings"

func replaceSpaces(S string, length int) string {
	var b strings.Builder
	for i := 0; i < length; i++ {
		if S[i] == ' ' {
			b.WriteString("%20")
		} else {
			b.WriteByte(S[i])
		}
	}
	return b.String()
}
