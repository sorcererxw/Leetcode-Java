package main

func findComplement(num int) int {
	var v int
	for i := 0; num > 0; i++ {
		if num%2 == 0 {
			v += 1 << i
		}
		num /= 2
	}
	return v
}
