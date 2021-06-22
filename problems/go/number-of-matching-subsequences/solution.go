package main

func numMatchingSubseq(s string, words []string) int {
	bucket := make(map[uint8][]string)
	for _, w := range words {
		if len(w) == 0 {
			continue
		}
		bucket[w[0]] = append(bucket[w[0]], w)
	}
	var cnt int
	for i := 0; i < len(s); i++ {
		head := s[i]
		size := len(bucket[head])
		if size == 0 {
			continue
		}
		for i := 0; i < size; i++ {
			w := bucket[head][i]
			if len(w) <= 1 {
				cnt++
				continue
			}
			w = w[1:]
			bucket[w[0]] = append(bucket[w[0]], w)
		}
		bucket[head] = bucket[head][size:]
	}
	return cnt
}
