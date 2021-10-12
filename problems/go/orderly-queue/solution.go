package orderly_queue

func orderlyQueue(s string, k int) string {
	if k == 1 {
		ret := s
		for i := 0; i < len(s); i++ {
			s = s[1:] + string(s[0])
			if s < ret {
				ret = s
			}
		}
		return ret
	} else {
		cnt := make([]int, 26)
		for i := 0; i < len(s); i++ {
			cnt[s[i]-'a']++
		}
		b := make([]uint8, 0, len(s))
		for i := uint8(0); i < uint8(len(cnt)); i++ {
			for j := 0; j < cnt[i]; j++ {
				b = append(b, i+'a')
			}
		}
		return string(b)
	}
}
