package evaluate_reverse_polish_notation

import (
	"strconv"
)

func evalRPN(tokens []string) int {
	s := make([]int, 0, len(tokens))
	for _, t := range tokens {
		switch t {
		case "+":
			a := s[len(s)-1]
			b := s[len(s)-2]
			s = s[:len(s)-2]
			s = append(s, a+b)
		case "-":
			a := s[len(s)-1]
			b := s[len(s)-2]
			s = s[:len(s)-2]
			s = append(s, b-a)
		case "/":
			a := s[len(s)-1]
			b := s[len(s)-2]
			s = s[:len(s)-2]
			s = append(s, b/a)
		case "*":
			a := s[len(s)-1]
			b := s[len(s)-2]
			s = s[:len(s)-2]
			s = append(s, a*b)
		default:
			n, _ := strconv.Atoi(t)
			s = append(s, n)
		}
	}
	return s[0]
}
