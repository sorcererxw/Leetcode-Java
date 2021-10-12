package _1629_slowest_key

func slowestKey(releaseTimes []int, keysPressed string) byte {
	var max int
	var result byte
	for i := 0; i < len(releaseTimes); i++ {
		last := 0
		if i > 0 {
			last = releaseTimes[i-1]
		}
		v := releaseTimes[i] - last
		if v > max || (v == max && keysPressed[i] > result) {
			max = v
			result = keysPressed[i]
		}
	}
	return result
}
