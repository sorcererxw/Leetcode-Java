package main

func maxTurbulenceSize(arr []int) int {
	var max, l int
	for i := 0; i < len(arr); i++ {
		if i == 0 {
			l += 1
		} else if l == 1 {
			if arr[i] != arr[i-1] {
				l += 1
			}
		} else if (arr[i-1]-arr[i-2])*(arr[i]-arr[i-1]) < 0 {
			l += 1
		} else {
			l = 2
		}
		if max < l {
			max = l
		}
	}
	return max
}
