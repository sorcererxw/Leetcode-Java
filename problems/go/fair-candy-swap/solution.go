package main

func fairCandySwap(A []int, B []int) []int {
	delta := 0
	for _, a := range A {
		delta += a
	}
	for _, b := range B {
		delta -= b
	}
	set := make(map[int]bool, 0)
	for _, b := range B {
		set[b] = true
	}
	for _, a := range A {
		if (2*a-delta)%2 != 0 {
			continue
		}
		if _, ok := set[(2*a-delta)/2]; ok {
			return []int{a, (2*a - delta) / 2}
		}
	}
	return nil
}

func main() {

}
