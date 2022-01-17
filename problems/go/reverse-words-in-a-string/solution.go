package main

import (
	"bytes"
)

func reverse(b []byte, i, j int) {
	for ; i < j; i, j = i+1, j-1 {
		b[i], b[j] = b[j], b[i]
	}
}

func reverseWords(s string) string {
	b := []byte(s)
	reverse(b, 0, len(b)-1)
	i := 0
	for j := 0; j <= len(b); j++ {
		if j >= len(b) || b[j] == ' ' {
			reverse(b, i, j-1)
			i = j + 1
		}
	}
	return string(bytes.TrimSpace(b))
}
