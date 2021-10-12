package decode_ways

var cache = make(map[string]int)

func numDecodings(s string) (ret int) {
	defer func() {
		cache[s] = ret
	}()
	if v, ok := cache[s]; ok {
		return v
	}
	if len(s) == 0 {
		return 1
	}
	var c int
	for i := 0; i < len(s); i++ {
		c = c*10 + int(s[i]-'0')
		if c >= 1 && c <= 26 {
			ret += numDecodings(s[i+1:])
		} else {
			break
		}
	}
	return ret
}
