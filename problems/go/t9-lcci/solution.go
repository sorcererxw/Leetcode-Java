package main

func getValidT9Words(num string, words []string) []string {
	ans := make([]string, 0, len(words))
	for _, w := range words {
		var s string
		for _, c := range w {
			var n int8
			switch c {
			case 'a', 'b', 'c':
				n = 2
			case 'd', 'e', 'f':
				n = 3
			case 'g', 'h', 'i':
				n = 4
			case 'j', 'k', 'l':
				n = 5
			case 'm', 'n', 'o':
				n = 6
			case 'p', 'q', 'r', 's':
				n = 7
			case 't', 'u', 'v':
				n = 8
			case 'w', 'x', 'y', 'z':
				n = 9
			}
			s += string('0' + n)
		}
		if s == num {
			ans = append(ans, w)
		}
	}
	return ans
}
