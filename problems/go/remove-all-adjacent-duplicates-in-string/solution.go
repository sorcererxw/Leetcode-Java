package main

func removeDuplicates(s string) string {
	stack := make([]uint8, 0, len(s))
	for i := 0; i < len(s); i++ {
		if len(stack) == 0 {
			stack = append(stack, s[i])
			continue
		}
		top := stack[len(stack)-1]
		if top == s[i] {
			stack = stack[:len(stack)-1]
		} else {
			stack = append(stack, s[i])
		}
	}
	return string(stack)
}
