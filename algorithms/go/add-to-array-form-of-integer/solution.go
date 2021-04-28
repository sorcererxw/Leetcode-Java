package _989_Add_to_Array_Form_of_Integer

func reverse(a []int) {
	for i, j := 0, len(a)-1; i < j; i, j = i+1, j-1 {
		a[i], a[j] = a[j], a[i]
	}
}

func addToArrayForm(A []int, K int) []int {
	reverse(A)
	B := make([]int, 0)
	for K > 0 {
		B = append(B, K%10)
		K /= 10
	}
	carry := 0
	dist := make([]int, 0)
	for i := 0; ; i++ {
		if carry == 0 && i >= len(A) && i >= len(B) {
			break
		}
		v := carry
		if i < len(A) {
			v += A[i]
		}
		if i < len(B) {
			v += B[i]
		}
		if v >= 10 {
			carry = 1
		} else {
			carry = 0
		}
		dist = append(dist, v%10)
	}
	reverse(dist)
	return dist
}
