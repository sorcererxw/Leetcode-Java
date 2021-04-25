package main

import (
	"fmt"
	"strconv"
)

func countAndSay(n int) string {
	s := ""
	for i := 0; i < n; i++ {
		if s == "" {
			s = "1"
			continue
		}
		ns := ""
		k := 0
		for j := 0; j < len(s); j++ {
			if j == 0 || s[j] != s[j-1] {
				if j > k {
					ns += fmt.Sprintf("%d%s",j-k,s[k])
				}
				k = j
			}
		}
		if len(s) > k {
			ns += fmt.Sprintf("%d%s",len(s)-k,s[k])
		}
		s = ns
	}
	return s
}