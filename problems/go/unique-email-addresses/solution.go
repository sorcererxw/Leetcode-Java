package main

import (
	"strings"
)

func numUniqueEmails(emails []string) int {
	set := make(map[string]struct{}, len(emails))
	for _, e := range emails {
		var b strings.Builder
		b.Grow(len(e))
		var ignore bool
		for i := range e {
			switch e[i] {
			case '.':
				continue
			case '+':
				ignore = true
				continue
			case '@':
				b.WriteString(e[i:])
				goto END
			default:
				if ignore {
					continue
				}
				b.WriteByte(e[i])
			}
		}
	END:
		set[b.String()] = struct{}{}
	}
	return len(set)
}
