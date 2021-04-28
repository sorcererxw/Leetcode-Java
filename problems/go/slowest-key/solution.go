package _1629_slowest_key

func slowestKey(releaseTimes []int, keysPressed string) byte {
	m := make(map[byte]int)
	var max int
	var result byte
	for i := 0; i < len(releaseTimes); i++ {
		last := 0
		if i > 0 {
			last = releaseTimes[i-1]
		}
		v := releaseTimes[i] - last
		m[keysPressed[i]] = v
		if v > max || (v == max && keysPressed[i] > result) {
			max = m[keysPressed[i]]
			result = keysPressed[i]
		}
	}
	return result
}
