package shifting_letters

func shiftingLetters(s string, shifts []int) string {
	chars := make([]uint8, len(shifts))
	cnt := 0
	for i := len(s) - 1; i >= 0; i-- {
		char := s[i]
		cnt += shifts[i]

		char = uint8((cnt+int(char-'a'))%26) + 'a'

		chars[i] = char
	}
	return string(chars)
}
